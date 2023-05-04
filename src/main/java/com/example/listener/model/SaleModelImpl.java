package com.example.listener.model;

import com.example.listener.entity.SaleItem;
import com.example.listener.entity.Voucher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleModelImpl implements SaleModel{

    private List<Voucher> vouchers;

    public SaleModelImpl(){
        vouchers = new ArrayList<>();
    }

    @Override
    public List<Voucher> getSaleHistory() {
        return new ArrayList<Voucher>(vouchers);
    }

    @Override
    public Voucher findById(int id) {
        for (var voucher : vouchers){
            if (id == voucher.getId()){
                return voucher;
            }
        }
        return null;
    }

    @Override
    public int create(String customer, List<SaleItem> sales) {
        Voucher voucher = new Voucher();
        voucher.setCustomer(customer);
        voucher.setSales(sales);
        voucher.setSaleTime(LocalDateTime.now());
        voucher.setId(vouchers.size() + 1);
        vouchers.add(voucher);
        return voucher.getId();
    }
}
