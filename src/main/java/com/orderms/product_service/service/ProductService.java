package com.orderms.product_service.service;

import com.orderms.product_service.dto.ProductRequestDTO;
import com.orderms.product_service.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO updateProduct(Long id ,ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> getAllProducts();

    void deleteProductById(Long id);


}
