package org.example.inventory.service;


import org.example.inventory.dto.ProductsDto;
import org.example.inventory.exception.ProductNotFoundException;
import org.example.inventory.model.Products;

import java.util.List;

public interface ProductsService {
    List<ProductsDto> get();

    ProductsDto getByID(String id) throws ProductNotFoundException;

    ProductsDto create(ProductsDto dto);

    ProductsDto update(String id, ProductsDto dto);

    void delete(String id);
}
