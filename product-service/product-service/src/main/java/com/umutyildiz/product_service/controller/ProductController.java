package com.umutyildiz.product_service.controller;

import com.umutyildiz.product_service.dto.ProductDto;
import com.umutyildiz.product_service.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Validated
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/")
    public ResponseEntity<ProductDto> getProduct(@Valid @NotBlank @RequestParam("barcode") String barcode){
        return ResponseEntity.ok(service.getProduct(barcode));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }
}
