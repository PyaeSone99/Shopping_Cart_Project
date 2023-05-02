package com.example.listener.entity;

public class SaleItem {
    private Product product;
    private int count;

    public int getUnitPrice(){
        return product.getPrice();
    }

    public int getTotal(){
        return count * getUnitPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
