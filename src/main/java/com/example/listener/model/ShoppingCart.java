package com.example.listener.model;

import com.example.listener.entity.Product;

import java.io.Serializable;

public interface ShoppingCart extends Serializable {

    void add(Product product);
    int itemCount();
    void clear();
    int total();
    public static ShoppingCart generate(){
        return null;
    }
}
