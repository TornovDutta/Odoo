package org.example.inventory.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.StockDto;
import org.example.inventory.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.inventory.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockRestController {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDto>> getAll() {
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getById(@PathVariable String id) throws StockNotFoundException {
        return ResponseEntity.ok(stockService.getById(id));
    }

    @GetMapping("/by-product/{productId}")
    public ResponseEntity<List<StockDto>> getByProduct(@PathVariable String productId) {
        return ResponseEntity.ok(stockService.getByProduct(productId));
    }

    @GetMapping("/by-warehouse/{warehouseId}")
    public ResponseEntity<List<StockDto>> getByWarehouse(@PathVariable String warehouseId) {
        return ResponseEntity.ok(stockService.getByWarehouse(warehouseId));
    }

    @GetMapping("/by-product-and-warehouse")
    public ResponseEntity<StockDto> getByProductAndWarehouse(
            @RequestParam String productId,
            @RequestParam String warehouseId
    ) {
        return ResponseEntity.ok(stockService.getByProductAndWarehouse(productId, warehouseId));
    }



    @PostMapping
    public ResponseEntity<StockDto> createOrUpdate(@RequestBody StockDto dto) {
        StockDto saved = stockService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
