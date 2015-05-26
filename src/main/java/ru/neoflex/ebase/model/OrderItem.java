package ru.neoflex.ebase.model;

import ru.CryptoPro.JCP.ASN.PKIXTSP.TimeStampReq;

import java.util.Date;

/**
 * Created by kshahin on 5/25/2015.
 */
public class OrderItem {
    private Long id;
    private Item item;
    private Customer customer;
    private String orderUUID;
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }
}
