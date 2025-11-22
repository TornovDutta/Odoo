package org.example.inventory.repo;

import org.example.inventory.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehouseRepo extends MongoRepository<Warehouse,String> {
}
