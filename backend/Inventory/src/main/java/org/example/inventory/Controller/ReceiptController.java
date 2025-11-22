package org.example.inventory.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.AddReceiptItemRequest;
import org.example.inventory.dto.CreateReceiptRequest;
import org.example.inventory.dto.ReceiptDto;
import org.example.inventory.service.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {
    private final ReceiptService service;
    @PostMapping
    public ResponseEntity<ReceiptDto> createReceipt(@RequestBody CreateReceiptRequest request) {
        return ResponseEntity.ok(service.createReceipt(request));
    }
    @PutMapping("/{id}/items")
    public ResponseEntity<ReceiptDto> addItem(
            @PathVariable String id,
            @RequestBody AddReceiptItemRequest request) {
        return ResponseEntity.ok(service.addItem(id, request));
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<ReceiptDto> validateReceipt(@PathVariable String id) {
        return ResponseEntity.ok(service.validateReceipt(id));
    }
}
