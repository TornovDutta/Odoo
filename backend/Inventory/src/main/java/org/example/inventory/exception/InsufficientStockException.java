package org.example.inventory.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String productId, String warehouseId, int requested, int available) {
        super("Insufficient stock for productId: " + productId +
                " in warehouseId: " + warehouseId +
                " (requested: " + requested + ", available: " + available + ")");
    }
}
