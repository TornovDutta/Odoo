package org.example.inventory.service.imple;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.WarehouseDto;
import org.example.inventory.exception.WarehouseNotFoundException;
import org.example.inventory.model.Warehouse;
import org.example.inventory.repo.WarehouseRepo;
import org.example.inventory.service.Warehouseservice;
import org.example.inventory.utility.WarehouseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseserviceImple implements Warehouseservice {
    private final WarehouseRepo warehouseRepo;
    private final WarehouseMapper warehouseMapper;

    @Override
    public WarehouseDto create(WarehouseDto dto) {
        Warehouse warehouse = warehouseMapper.toEntity(dto);
        Warehouse saved = warehouseRepo.save(warehouse);
        return warehouseMapper.toDto(saved);
    }

    @Override
    public WarehouseDto update(String id, WarehouseDto dto) {
        Warehouse existing = warehouseRepo.findById(id)
                .orElseThrow(() -> new WarehouseNotFoundException(id));

        existing.setName(dto.name());
        existing.setParentId(dto.parentId());

        Warehouse updated = warehouseRepo.save(existing);
        return warehouseMapper.toDto(updated);
    }

    @Override
    public WarehouseDto getById(String id) {
        Warehouse warehouse = warehouseRepo.findById(id)
                .orElseThrow(() -> new WarehouseNotFoundException(id));
        return warehouseMapper.toDto(warehouse);
    }

    @Override
    public List<WarehouseDto> getAll() {
        return warehouseRepo.findAll()
                .stream()
                .map(warehouseMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Warehouse warehouse = warehouseRepo.findById(id)
                .orElseThrow(() -> new WarehouseNotFoundException(id));
        warehouseRepo.delete(warehouse);
    }

}
