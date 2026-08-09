package com.orderms.product_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String sku;
    private Integer stockQuantity;
    private BigDecimal price;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

}
