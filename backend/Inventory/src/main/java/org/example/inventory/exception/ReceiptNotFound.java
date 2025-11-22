package org.example.inventory.exception;

public class ReceiptNotFound extends RuntimeException{
    public ReceiptNotFound(String msg) {
        super(msg);
    }
}
