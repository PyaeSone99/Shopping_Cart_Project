package com.example.listener.model;

import com.example.listener.entity.Product;
import com.example.listener.entity.SaleItem;

import java.io.Serializable;
import java.util.List;

public interface ShoppingCart extends Serializable {

    void add(Product product);
    int itemCount();
    void clear();
    int total();
    public static ShoppingCart generate(){
        return new shoppingCartImpl();
    }

    public void changeItemCount(boolean plus,int productId);
    List<SaleItem> items();
}
