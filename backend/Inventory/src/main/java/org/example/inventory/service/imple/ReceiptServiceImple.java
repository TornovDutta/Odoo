package org.example.inventory.service.imple;

import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.AddReceiptItemRequest;
import org.example.inventory.dto.CreateReceiptRequest;
import org.example.inventory.dto.ReceiptDto;
import org.example.inventory.dto.ReceiptItemDto;
import org.example.inventory.exception.ProductNotFoundException;
import org.example.inventory.exception.ReceiptNotFound;
import org.example.inventory.model.Products;
import org.example.inventory.model.Receipt;
import org.example.inventory.model.ReceiptItem;
import org.example.inventory.repo.ProductsRepo;
import org.example.inventory.repo.ReceiptRepo;
import org.example.inventory.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImple implements ReceiptService {
    private final ReceiptRepo receiptRepo;
    private final ProductsRepo productsRepo;

    @Override
    public ReceiptDto createReceipt(CreateReceiptRequest request) {

        Receipt receipt = new Receipt(
                null,
                request.supplier(),
                "DRAFT",
                LocalDateTime.now(),
                new ArrayList<>()
        );

        Receipt saved = receiptRepo.save(receipt);
        return toDto(saved);
    }

    @Override
    public ReceiptDto addItem(String receiptId, AddReceiptItemRequest request) {

        Receipt receipt = receiptRepo.findById(receiptId)
                .orElseThrow(() -> new ReceiptNotFound(receiptId + " not found"));

        Products product = productsRepo.findById(request.productId())
                .orElseThrow(() -> new ProductNotFoundException(request.productId()));

        ReceiptItem item = new ReceiptItem(
                request.productId(),
                request.quantity()
        );

        receipt.getItems().add(item);

        Receipt updated = receiptRepo.save(receipt);
        return toDto(updated);
    }


    @Override
    public ReceiptDto validateReceipt(String receiptId) {

        Receipt receipt = receiptRepo.findById(receiptId)
                .orElseThrow(() -> new ReceiptNotFound(receiptId));

        if (receipt.getItems() == null || receipt.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot validate an empty receipt");
        }


        for (ReceiptItem item : receipt.getItems()) {

            Products product = productsRepo.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(item.getProductId()));

            product.setLowStockAlert(product.getLowStockAlert() + item.getQuantity());

            productsRepo.save(product);
        }

        receipt.setStatus("VALIDATED");

        Receipt validated = receiptRepo.save(receipt);
        return toDto(validated);
    }



    private ReceiptDto toDto(Receipt receipt) {
        List<ReceiptItemDto> itemDtos = receipt.getItems()
                .stream()
                .map(i -> new ReceiptItemDto(i.getProductId(), i.getQuantity()))
                .toList();

        return new ReceiptDto(
                receipt.getId(),
                receipt.getSupplier(),
                receipt.getStatus(),
                receipt.getCreatedAt(),
                itemDtos
        );
    }
}
