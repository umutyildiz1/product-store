package com.umutyildiz.product_service.service;

import com.umutyildiz.commons.DtoConverter;
import com.umutyildiz.product_service.controller.request.GetProductsByBarcodeRequest;
import com.umutyildiz.product_service.controller.response.GetProductsByBarcodeResponse;
import com.umutyildiz.product_service.dto.ProductDto;
import com.umutyildiz.product_service.entity.Product;
import com.umutyildiz.product_service.exception.ProductNotFoundException;
import com.umutyildiz.product_service.helper.ProductServiceHelper;
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
    private final ProductServiceHelper helper;

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

    @Override
    public GetProductsByBarcodeResponse getProductsByBarcode(GetProductsByBarcodeRequest request) {
        //todo Çok büyük id listesi geldiği durumu async bir servisle ayrı ayrı thread ile okuyup birleştiren ve id sıralaması yapan bir yapıya dönüştür
        //helper.getProductsByBarcodeAsync();//todo barcode alanına index ekle
        var products = repository.findProductsByBarcode(request.getBarcodes()).orElse(emptyList());

        return GetProductsByBarcodeResponse.builder()
                .products(converter.toDto(products))
                .build();
    }

    @Override
    public ProductDto getProductByName(String name) {
        var product = repository.findProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product not found name : %s", name)));

        return ProductDto.builder()
                .name(product.getName())
                .barcode(product.getBarcode())
                .quantity(product.getQuantity())
                .build();
    }
}
