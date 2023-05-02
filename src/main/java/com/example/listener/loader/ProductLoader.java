package com.example.listener.loader;

import com.example.listener.entity.Product;
import com.example.listener.model.ProductModel;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.io.BufferedReader;
import java.io.FileReader;

@WebListener
public class ProductLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        var model = new ProductModel();

        String filePath = sce.getServletContext().getRealPath("/WEB-INF/product");
        try(BufferedReader input = new BufferedReader(new FileReader(filePath))) {

            String line = null;
            while (null != (line = input.readLine()) ){
                var array = line.split("\t");
                model.add(new Product(array[1] , array[0] , Integer.parseInt( array[2] )));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        sce.getServletContext().setAttribute("products",model);
    }
}


























