package com.rbu.ecp.service;

import com.rbu.ecp.dto.PaymentInfo;
import com.rbu.ecp.dto.Purchase;
import com.rbu.ecp.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
