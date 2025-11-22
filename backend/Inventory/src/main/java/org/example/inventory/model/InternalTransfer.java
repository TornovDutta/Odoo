package org.example.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "transfers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalTransfer {
    @Id
    private String id;

    private String fromWarehouseId;
    private String toWarehouseId;

    private String status;

    private LocalDateTime createdAt;

    private List<TransferItem> items;
}
