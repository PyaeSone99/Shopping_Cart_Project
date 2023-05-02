package com.example.listener.model;

import com.example.listener.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private List<Product> list;

    public ProductModel(){
        list = new ArrayList<>();
    }

    public void add(Product p){
        list.add(p);
        p.setId(list.size());
    }

    public List<Product> getList(){
        return new ArrayList<>(list);
    }

    public Product findById(int id){
        for (Product p : list){
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
