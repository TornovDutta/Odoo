package org.example.inventory.exception;

public class WarehouseNotFoundException extends Exception {
    public WarehouseNotFoundException(String msg){
        super(msg);
    }
}
