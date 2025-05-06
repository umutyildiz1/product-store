package com.umutyildiz.product_service.service;

import com.umutyildiz.product_service.converter.DtoConverter;
import com.umutyildiz.product_service.dto.ProductDto;
import com.umutyildiz.product_service.entity.Product;
import com.umutyildiz.product_service.exception.ProductNotFoundException;
import com.umutyildiz.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final DtoConverter<ProductDto, Product> converter;

    @Override
    public ProductDto getProduct(String barcode) {
        var product = repository.findProductByBarcode(barcode)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product not found barcode : %s", barcode)));

        return ProductDto.builder()
                .name(product.getName())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public List<ProductDto> getProducts() {
        var products = Optional.ofNullable(repository.findAll()).orElse(emptyList());

        return converter.toDto(products);
    }
}
