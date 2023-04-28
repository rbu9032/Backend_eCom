package com.rbu.ecp.dto;


import com.rbu.ecp.entity.Address;
import com.rbu.ecp.entity.Customer;
import com.rbu.ecp.entity.Order;
import com.rbu.ecp.entity.OrderItem;

import java.util.Set;

public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "customer=" + customer +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                ", order=" + order +
                ", orderItems=" + orderItems +
                '}';
    }
}
