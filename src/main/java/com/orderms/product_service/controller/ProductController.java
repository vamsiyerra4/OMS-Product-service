package com.orderms.product_service.controller;

import com.orderms.product_service.dto.ProductRequestDTO;
import com.orderms.product_service.dto.ProductResponseDTO;
import com.orderms.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(productRequestDTO));

    }

    @GetMapping("/{id}")
   public ResponseEntity<ProductResponseDTO> getProductById(@Valid @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProductById(id));
   }

   @GetMapping
   public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAllProducts());
   }

   @PutMapping("/{id}")
   public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,
           @Valid @RequestBody ProductRequestDTO productRequestDTO) {

        return  ResponseEntity.status(HttpStatus.OK)
                .body(productService.updateProduct(id, productRequestDTO));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);

        return ResponseEntity.noContent().build();
   }


}
