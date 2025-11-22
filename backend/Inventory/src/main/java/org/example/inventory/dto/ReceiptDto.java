package org.example.inventory.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ReceiptDto(String id,
                         String supplier,
                         String status,
                         LocalDateTime createdAt,
                         List<ReceiptItemDto> items) {
}
