package com.umutyildiz.store_service.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientProductDto {

    private String name;
    private String barcode;
    private Integer quantity;
}
