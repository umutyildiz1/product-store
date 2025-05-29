package com.umutyildiz.product_service.helper;

import com.umutyildiz.product_service.entity.Product;
import com.umutyildiz.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceHelper {

    private final ProductRepository repository;

    public List<Product> getProductsByBarcodeAsync(List<String> barcodes){
//todo
        return Collections.emptyList();
    }
}
