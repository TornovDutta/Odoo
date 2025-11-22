package org.example.inventory.dto;

public record StockDto(String id,
                       String productId,
                       String warehouseId,
                       Integer quantity) {
}
