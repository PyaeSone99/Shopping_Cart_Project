package com.example.listener.loader;

import com.example.listener.model.ProductModel;
import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class ProductModelCreationListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        var value = event.getValue();

        if (value instanceof ProductModel){
            var name = event.getName();
            event.getServletContext().log(String.format("Product Model is created at %s", LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            event.getServletContext().log(String.format("Attribute name is %s",name));
            ProductModel model = (ProductModel) value;
            event.getServletContext().log(String.format("Product Count is %s",model.getList().size()));
        }
    }
}
