package org.example.inventory.utility;


import org.example.inventory.dto.WarehouseDto;
import org.example.inventory.model.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper {
    public WarehouseDto  toDto(Warehouse warehouse) {
        return new WarehouseDto(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getParentId()
        );
    }
    public Warehouse toEntity(WarehouseDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(dto.id());
        warehouse.setName(dto.name());
        warehouse.setParentId(dto.parentId());
        return warehouse;
    }

}
