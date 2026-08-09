package com.orderms.product_service.service;

import com.orderms.product_service.dto.ProductRequestDTO;
import com.orderms.product_service.dto.ProductResponseDTO;
import com.orderms.product_service.entity.Product;
import com.orderms.product_service.exception.DuplicateSkuException;
import com.orderms.product_service.exception.ProductNotFoundExcpetion;
import com.orderms.product_service.mapper.ProductMapper;
import com.orderms.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        if(productRepository.existsBySku(productRequestDTO.getSku())) {
            throw new DuplicateSkuException("Product already exist " + productRequestDTO.getSku());
        }

        Product product = productMapper.toEntity(productRequestDTO);
        Product savedProduct = productRepository.save(product);

        return productMapper.toResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundExcpetion("Product not found with id " + id));

        productMapper.UpdateProductEntity(product,productRequestDTO);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(updatedProduct);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundExcpetion("Product not found with id " + id));
        return productMapper.toResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll().stream().map(productMapper::toResponseDTO).toList();
    }

    @Override
    public void deleteProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductNotFoundExcpetion("Product not found with id " + id));

        productRepository.delete(product);

    }
}
