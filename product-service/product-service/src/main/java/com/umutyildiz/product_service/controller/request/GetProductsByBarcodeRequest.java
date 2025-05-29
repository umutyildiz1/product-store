package com.umutyildiz.product_service.controller.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetProductsByBarcodeRequest {

    private List<String> barcodes;

}
