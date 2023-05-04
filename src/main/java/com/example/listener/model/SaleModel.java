package com.example.listener.model;

import com.example.listener.entity.SaleItem;
import com.example.listener.entity.Voucher;

import java.util.List;

public interface SaleModel {
    static SaleModel model(){
        return new SaleModelImpl();
    }

    List<Voucher> getSaleHistory();

    Voucher findById(int id);

    int create(String customer, List<SaleItem> sales);
}
