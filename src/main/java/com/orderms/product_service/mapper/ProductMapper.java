package com.orderms.product_service.mapper;

import com.orderms.product_service.dto.ProductRequestDTO;
import com.orderms.product_service.dto.ProductResponseDTO;
import com.orderms.product_service.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO requestDTO) {

        return Product.builder()
                .name(requestDTO.getName())
                .sku(requestDTO.getSku())
                .stockQuantity(requestDTO.getStockQuantity())
                .price(requestDTO.getPrice())
                .build();
    }

    public ProductResponseDTO toResponseDTO(Product product) {

        return ProductResponseDTO.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .stockQuantity(product.getStockQuantity())
                .price(product.getPrice())
                .createdDate(product.getCreatedDate())
                .updatedDate(product.getUpdatedDate())
                .build();

    }

    public void UpdateProductEntity(Product product, ProductRequestDTO requestDTO) {

        product.setName(requestDTO.getName());
        product.setSku(requestDTO.getSku());
        product.setStockQuantity(requestDTO.getStockQuantity());
        product.setPrice(requestDTO.getPrice());

    }

}
