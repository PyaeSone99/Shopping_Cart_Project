package com.example.listener.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voucher {

    private int id;
    private String customer;
    private LocalDateTime saleTime;
    private List<SaleItem> sales;

    public int itemCount(){
        int count =0 ;
        for (var s : sales){
            count += s.getCount();
        }

        return count;
    }

    public int total(){
        int total = 0;
        for (var s : sales){
            total += s.getTotal();
        }
        return total;
    }

    public Voucher() {
        sales = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalDateTime saleTime) {
        this.saleTime = saleTime;
    }

    public List<SaleItem> getSales() {
        return sales;
    }

    public void setSales(List<SaleItem> sales) {
        this.sales = sales;
    }
}
