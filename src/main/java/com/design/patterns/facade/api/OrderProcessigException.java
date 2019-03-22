package com.design.patterns.facade.api;

public class OrderProcessigException extends Exception{
    public static String ERR_NOT_AUTHORISED = "User is nt authorised";
    public static String ERR_PAYMENT_REJECTED = "Payment was rejected";
    public static String ERR_VERIFICATION_ERROR = "Verification error";
    public static String ERR_SUBMITTING_ERROR = "Cannot submit order";

    public OrderProcessigException(String message) {
        super(message);
    }
}
