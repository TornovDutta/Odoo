package org.example.inventory.utility;

import org.example.inventory.dto.StockDto;
import org.example.inventory.model.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {
    public StockDto toDto(Stock stock) {
        return new StockDto(
                stock.getId(),
                stock.getProductId(),
                stock.getWarehouseId(),
                stock.getQuantity()
        );
    }

    public Stock toEntity(StockDto dto) {
        Stock stock = new Stock();
        stock.setId(dto.id());
        stock.setProductId(dto.productId());
        stock.setWarehouseId(dto.warehouseId());
        stock.setQuantity(dto.quantity());
        return stock;
    }
}
