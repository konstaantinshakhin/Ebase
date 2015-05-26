package ru.neoflex.ebase.model;

import java.util.List;

/**
 * Created by kshahin on 5/26/2015.
 */
public class Cart {

    private List<OrderItem> itemList;

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
}
