package org.example.inventory.service;

import org.example.inventory.dto.WarehouseDto;

import java.util.List;

public interface Warehouseservice  {
    WarehouseDto create(WarehouseDto dto);

    WarehouseDto update(String id, WarehouseDto dto);

    WarehouseDto getById(String id);

    List<WarehouseDto> getAll();

    void delete(String id);
}
