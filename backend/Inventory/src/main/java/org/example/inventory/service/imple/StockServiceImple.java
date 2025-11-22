package org.example.inventory.service.imple;


import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.StockDto;
import org.example.inventory.exception.InsufficientStockException;
import org.example.inventory.exception.StockNotFoundException;
import org.example.inventory.model.Stock;
import org.example.inventory.repo.StockRepo;
import org.example.inventory.service.StockService;
import org.example.inventory.utility.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImple implements StockService {
    private final StockRepo stockRepo;
    private final StockMapper stockMapper;


    @Override
    public StockDto getById(String id) throws StockNotFoundException {
        Stock stock = stockRepo.findById(id)
                .orElseThrow(() -> new StockNotFoundException(id));
        return stockMapper.toDto(stock);
    }

    @Override
    public List<StockDto> getAll() {
        return stockRepo.findAll()
                .stream()
                .map(stockMapper::toDto)
                .toList();
    }

    @Override
    public List<StockDto> getByProduct(String productId) {
        return stockRepo.findByProductId(productId)
                .stream()
                .map(stockMapper::toDto)
                .toList();
    }

    @Override
    public List<StockDto> getByWarehouse(String warehouseId) {
        return stockRepo.findByWarehouseId(warehouseId)
                .stream()
                .map(stockMapper::toDto)
                .toList();
    }


    @Override
    public StockDto getByProductAndWarehouse(String productId, String warehouseId) throws StockNotFoundException {
        Stock stock = stockRepo.findByProductIdAndWarehouseId(productId, warehouseId)
                .orElseThrow(() -> new StockNotFoundException(productId+ warehouseId));
        return stockMapper.toDto(stock);
    }

    @Override
    public StockDto save(StockDto dto) {
        Stock entity = stockMapper.toEntity(dto);
        Stock saved = stockRepo.save(entity);
        return stockMapper.toDto(saved);
    }

    @Override
    public void delete(String id) throws StockNotFoundException {
        Stock stock = stockRepo.findById(id)
                .orElseThrow(() -> new StockNotFoundException(id));
        stockRepo.delete(stock);
    }


    @Override
    public void increaseStock(String productId, String warehouseId, int quantity) {
        if (quantity <= 0) return;

        Stock stock = stockRepo.findByProductIdAndWarehouseId(productId, warehouseId)
                .orElseGet(() -> new Stock(null, productId, warehouseId, 0));

        stock.setQuantity(stock.getQuantity() + quantity);
        stockRepo.save(stock);
    }

    @Override
    public void decreaseStock(String productId, String warehouseId, int quantity) throws StockNotFoundException {
        if (quantity <= 0) return;

        Stock stock = stockRepo.findByProductIdAndWarehouseId(productId, warehouseId)
                .orElseThrow(() -> new StockNotFoundException(productId+warehouseId));

        int available = stock.getQuantity() != null ? stock.getQuantity() : 0;

        if (available < quantity) {
            throw new InsufficientStockException(productId, warehouseId, quantity, available);
        }

        stock.setQuantity(available - quantity);
        stockRepo.save(stock);
    }


    @Override
    public void setStock(String productId, String warehouseId, int newQuantity) {
        Stock stock = stockRepo.findByProductIdAndWarehouseId(productId, warehouseId)
                .orElseGet(() -> new Stock(null, productId, warehouseId, 0));

        stock.setQuantity(newQuantity);
        stockRepo.save(stock);
    }
}
