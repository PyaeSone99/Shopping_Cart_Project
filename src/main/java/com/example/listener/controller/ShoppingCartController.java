package com.example.listener.controller;


import com.example.listener.entity.Product;
import com.example.listener.model.ProductModel;
import com.example.listener.model.ShoppingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/cart-add",
        "/cart-show",
        "/cart-clear"
})
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getServletPath()){
            case "/cart-add":
                break;
            case "/cart-show":
                break;
            case "/cart-clear":
                break;
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var strId = req.getParameter("product");

        var productModel = (ProductModel)getServletContext().getAttribute("products");

        Product product = productModel.findById(Integer.parseInt(strId));

        var session = req.getSession(true);
        var cart = (ShoppingCart) session.getAttribute("cart");
        if ( cart == null ){
            cart = ShoppingCart.generate();
            session.setAttribute("cart",cart);
        }
        cart.add(product);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}



















