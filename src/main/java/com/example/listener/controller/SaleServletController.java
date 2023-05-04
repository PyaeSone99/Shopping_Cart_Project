package com.example.listener.controller;

import com.example.listener.entity.Voucher;
import com.example.listener.model.SaleModel;
import com.example.listener.model.ShoppingCart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/sale-history",
        "/sale-details",
        "/checkout"
})
public class SaleServletController extends HttpServlet {

    private SaleModel model;

    @Override
    public void init() throws ServletException {
        var application = getServletContext();
        model = (SaleModel) application.getAttribute("sale.model");
        System.out.println("Hello");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()){
            case "/sale-history":
                showSaleHistory(req, resp);
                break;
            case "/sale-details":
                showDetails(req,resp);
                break;
        }
    }

    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var str = req.getParameter("id");
        var id = Integer.parseInt(str);
        var voucher = model.findById(id);
        req.setAttribute("data",voucher);
        getServletContext().getRequestDispatcher("/sale-details.jsp").forward(req,resp);
    }

    private void showSaleHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Voucher> list  = model.getSaleHistory();
        req.setAttribute("data",list);
        getServletContext().getRequestDispatcher("/sale-list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var customer = req.getParameter("customer");
        var cart = (ShoppingCart)req.getSession().getAttribute("cart");
        var sales = cart.items();
        var voucherId = model.create(customer,sales);
        req.getSession().removeAttribute("cart");
        resp.sendRedirect(getServletContext().getContextPath().concat("/sale-details?id=")+voucherId);

    }
}























