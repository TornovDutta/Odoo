package org.example.inventory.exception;

public class StockNotFoundException extends Exception {
    public StockNotFoundException(String message) {
        super(message);
    }
}
