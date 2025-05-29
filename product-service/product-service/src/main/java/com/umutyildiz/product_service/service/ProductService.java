package com.umutyildiz.product_service.service;

import com.umutyildiz.product_service.controller.request.GetProductsByBarcodeRequest;
import com.umutyildiz.product_service.controller.response.GetProductsByBarcodeResponse;
import com.umutyildiz.product_service.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(String barcode);
    List<ProductDto> getProducts();
    GetProductsByBarcodeResponse getProductsByBarcode(GetProductsByBarcodeRequest request);
    ProductDto getProductByName(String name);
}
