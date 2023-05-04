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
        var item = findItemByProduct(product.getId());
        if (item == null){
            item = new SaleItem();
            item.setProduct(product);
            items.add(item);
        }
        item.addOne();
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

    @Override
    public List<SaleItem> items() {
        return new ArrayList<SaleItem>(items);
    }

    private SaleItem findItemByProduct(int product){
        for (SaleItem item : items){
            if (item.getProduct().getId() == product){
                return item;
            }
        }
        return null;
    }

    @Override
    public void changeItemCount(boolean plus, int productId) {
        var item = findItemByProduct(productId);
        if (item != null){
            item.changeCount(plus);
            if (item.getCount() == 0){
                items.remove(item);
            }
        }
    }



}
