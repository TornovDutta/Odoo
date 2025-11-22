package org.example.inventory.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inventory.service.Warehouseservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {
    private final Warehouseservice service;
//    @PostMapping
//    public ResponseEntity<>
}
