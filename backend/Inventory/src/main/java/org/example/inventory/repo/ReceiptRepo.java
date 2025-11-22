package org.example.inventory.repo;

import org.example.inventory.model.Products;
import org.example.inventory.model.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepo extends MongoRepository<Receipt,String> {
}
