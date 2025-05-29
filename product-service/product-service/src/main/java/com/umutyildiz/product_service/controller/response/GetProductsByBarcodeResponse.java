package com.umutyildiz.product_service.controller.response;

import com.umutyildiz.product_service.dto.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class GetProductsByBarcodeResponse {

    private List<ProductDto> products;

}
