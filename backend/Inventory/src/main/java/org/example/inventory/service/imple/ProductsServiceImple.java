package org.example.inventory.service.imple;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.ProductsDto;
import org.example.inventory.exception.ProductNotFoundException;
import org.example.inventory.model.Products;
import org.example.inventory.repo.ProductsRepo;
import org.example.inventory.service.ProductsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImple implements ProductsService {
    private final ProductsRepo repo;
    public List<ProductsDto> get(){
        List<Products> products=repo.findAll();
        List<ProductsDto> returnAns=new ArrayList<>();
        for(Products p:products){
            returnAns.add(
                    new ProductsDto(p.getId(),p.getName(),p.getSku(),p.getCategory(),p.getUom(),p.getLowStockAlert())
            );
        }
        return returnAns;
    }
    public ProductsDto getByID(String id) throws ProductNotFoundException{
        Products products = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("id not found"));


        return new ProductsDto(
                products.getId(),
                products.getName(),
                products.getSku(),
                products.getCategory(),
                products.getUom(),
                products.getLowStockAlert()
        );
    }
    public ProductsDto create(ProductsDto dto) {
        Products p = new Products(
                null,
                dto.name(),
                dto.sku(),
                dto.category(),
                dto.uom(),
                dto.lowStockAlert()
        );

        Products saved = repo.save(p);

        return new ProductsDto(
                saved.getId(),
                saved.getName(),
                saved.getSku(),
                saved.getCategory(),
                saved.getUom(),
                saved.getLowStockAlert()
        );
    }
    public ProductsDto update(String id, ProductsDto dto) {
        Products existing = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("id not found"));

        existing.setName(dto.name());
        existing.setSku(dto.sku());
        existing.setCategory(dto.category());
        existing.setUom(dto.uom());
        existing.setLowStockAlert(dto.lowStockAlert());

        Products updated = repo.save(existing);

        return new ProductsDto(
                updated.getId(),
                updated.getName(),
                updated.getSku(),
                updated.getCategory(),
                updated.getUom(),
                updated.getLowStockAlert()
        );
    }
    public void delete(String id) {
        Products existing = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("id not found"));

        repo.delete(existing);
    }



}
