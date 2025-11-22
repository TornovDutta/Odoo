package org.example.inventory.repo;

import org.example.inventory.model.Stock;
import org.example.inventory.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepo extends MongoRepository<Stock,String> {
    List<Stock> findByProductId(String productId);

    List<Stock> findByWarehouseId(String warehouseId);


    Optional<Stock> findByProductIdAndWarehouseId(String productId, String warehouseId);

}