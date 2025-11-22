package org.example.inventory.repo;

import org.example.inventory.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepo extends MongoRepository<Products,String> {
}
