package org.example.inventory.service;

import org.example.inventory.dto.StockDto;
import org.example.inventory.exception.StockNotFoundException;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StockService {
    @Nullable List<StockDto> getAll();

    @Nullable StockDto getById(String id) throws StockNotFoundException;

    @Nullable List<StockDto> getByProduct(String productId);

    @Nullable List<StockDto> getByWarehouse(String warehouseId);

    @Nullable StockDto getByProductAndWarehouse(String productId, String warehouseId) throws StockNotFoundException;

    StockDto save(StockDto dto);

    void delete(String id) throws StockNotFoundException;
    void setStock(String productId, String warehouseId, int newQuantity);
    void decreaseStock(String productId, String warehouseId, int quantity) throws StockNotFoundException;
    void increaseStock(String productId, String warehouseId, int quantity);


}
