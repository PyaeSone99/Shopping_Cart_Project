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
        "/cart-clear",
        "/cart-minus",
        "/cart-plus"
})
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getServletPath()){
            case "/cart-add":
                addToCart(req, resp);
                break;
            case "/cart-show":
                getServletContext().getRequestDispatcher("/my-cart.jsp").forward(req,resp);
                break;
            case "/cart-clear":
                clear(req, resp);
                break;
            case "/cart-minus":
            case "/cart-plus":
                changeCartItemCount(req,resp);
                break;
        }
    }

    private void changeCartItemCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var cart = (ShoppingCart) req.getSession().getAttribute("cart");

        var product = req.getParameter("product");
        var plus = "/cart-plus".equals(req.getServletPath());
        cart.changeItemCount(plus,Integer.parseInt(product));

        var link = req.getContextPath().concat("/my-cart.jsp");
        resp.sendRedirect(link);
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

    private void clear(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        var session = req.getSession();

        if (null != session){
            var cart = (ShoppingCart)session.getAttribute("cart");
            cart.clear();
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}

















