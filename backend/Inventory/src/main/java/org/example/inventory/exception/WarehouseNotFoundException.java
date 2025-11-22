package org.example.inventory.exception;

public class WarehouseNotFoundException extends RuntimeException{
    public WarehouseNotFoundException(String msg){
        super(msg);
    }
}
