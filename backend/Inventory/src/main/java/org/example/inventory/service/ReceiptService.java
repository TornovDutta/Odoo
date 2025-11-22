package org.example.inventory.service;

import org.example.inventory.dto.AddReceiptItemRequest;
import org.example.inventory.dto.CreateReceiptRequest;
import org.example.inventory.dto.ReceiptDto;
import org.jspecify.annotations.Nullable;

public interface ReceiptService  {

    @Nullable ReceiptDto createReceipt(CreateReceiptRequest request);

    @Nullable ReceiptDto addItem(String id, AddReceiptItemRequest request);

    @Nullable ReceiptDto validateReceipt(String id);
}
