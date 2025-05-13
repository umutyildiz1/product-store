package com.umutyildiz.product_service.dto;

import com.umutyildiz.product_service.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private String name;
    private String barcode;
    private Integer quantity;

    public static ProductDto convert(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .barcode(product.getBarcode())
                .quantity(product.getQuantity())
                .build();
    }
}
