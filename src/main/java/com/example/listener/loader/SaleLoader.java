package com.example.listener.loader;

import com.example.listener.model.SaleModel;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SaleLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var model = SaleModel.model();
        sce.getServletContext().setAttribute("sale.model",model);

    }
}
