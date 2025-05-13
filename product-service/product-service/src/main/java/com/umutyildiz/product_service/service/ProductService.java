package com.umutyildiz.product_service.service;

import com.umutyildiz.product_service.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(String barcode);
    List<ProductDto> getProducts();
}
