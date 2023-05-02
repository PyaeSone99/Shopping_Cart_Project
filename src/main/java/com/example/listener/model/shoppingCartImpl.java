package com.example.listener.model;

import com.example.listener.entity.Product;
import com.example.listener.entity.SaleItem;

import java.util.ArrayList;
import java.util.List;

class shoppingCartImpl implements ShoppingCart{

    private List<SaleItem> items;

    public shoppingCartImpl() {
        items = new ArrayList<SaleItem>();
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public int itemCount() {
        int count = 0;
        for (SaleItem item : items){
            count += item.getCount();
        }
        return count;
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public int total() {
        int total = 0;
        for (SaleItem item : items){
            total += item.getTotal();
        }
        return total;
    }
}
