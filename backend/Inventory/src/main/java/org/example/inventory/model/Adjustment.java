package org.example.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Adjustment {
    @Id
    private String id;

    private String productId;
    private String warehouseId;

    private Integer countedQuantity;
    private Integer systemQuantity;

    private Integer difference;

    private LocalDateTime createdAt;
}
