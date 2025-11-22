package org.example.inventory.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inventory.service.ReceiptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {
    private final ReceiptService service;
}
