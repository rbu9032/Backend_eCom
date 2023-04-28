package com.rbu.ecp.dto;

public class PurchaseResponse {

    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }


    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "orderTrackingNumber='" + orderTrackingNumber + '\'' +
                '}';
    }
}
