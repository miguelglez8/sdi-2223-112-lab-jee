package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletRemoveShoppingCart", value = "/RemoveShoppingCart")
public class ServletRemoveShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart =
                (HashMap<String, Integer>) request.getSession().getAttribute("cart");
        // No hay carrito, creamos uno y lo insertamos en sesión
        if (cart == null) {
            cart = new HashMap<String, Integer>();
            request.getSession().setAttribute("cart", cart);
        }
        String product = request.getParameter("product");
        if (product != null) {
            removeShoppingCart(cart, product);
        }
        request.setAttribute("selectedItems", cart);
        getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private void removeShoppingCart(Map<String, Integer> cart, String productKey) {
        if (cart.get(productKey)==Integer.valueOf(1)) {
            cart.remove(productKey);
        } else {
            int productCount = (Integer) cart.get(productKey).intValue();
            cart.put(productKey, Integer.valueOf(productCount - 1));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
