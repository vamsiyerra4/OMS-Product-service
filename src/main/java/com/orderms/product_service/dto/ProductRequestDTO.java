package com.orderms.product_service.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100,message = "Name must be less than 100 characters")
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value ="0.01",message = "Price must be greater then zero")
    private BigDecimal price;

    @NotBlank(message = "SKU is required")
    @Size(max = 50, message = "SKU must not exceed 50 characters")
    private String sku;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0 , message = "Should quantity cannot be negative")
    private Integer stockQuantity;

}
