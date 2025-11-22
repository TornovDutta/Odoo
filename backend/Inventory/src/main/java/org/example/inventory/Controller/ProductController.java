package org.example.inventory.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.ProductsDto;
import org.example.inventory.exception.ProductNotFoundException;
import org.example.inventory.model.Products;
import org.example.inventory.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;
    @GetMapping
    public ResponseEntity<List<ProductsDto>> getAll(){
        return new ResponseEntity<>(productsService.get(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getA(@RequestParam String id) throws ProductNotFoundException {
        return new ResponseEntity<>(productsService.getByID(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductsDto> create(@RequestBody ProductsDto dto) {
        ProductsDto saved = productsService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id,
                                              @RequestBody ProductsDto dto) {
        ProductsDto updated = productsService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        productsService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
