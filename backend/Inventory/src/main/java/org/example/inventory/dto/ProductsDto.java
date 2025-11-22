package org.example.inventory.dto;

import lombok.Data;


public record ProductsDto(
        String id,
        String name,
        String sku,
        String category,
        String uom,
        Integer lowStockAlert
) {
}
