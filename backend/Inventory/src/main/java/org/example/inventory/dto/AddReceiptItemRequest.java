package org.example.inventory.dto;

public record AddReceiptItemRequest(String productId,
                                    Integer quantity) {
}
