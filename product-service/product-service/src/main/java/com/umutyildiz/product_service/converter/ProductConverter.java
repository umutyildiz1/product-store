package com.umutyildiz.product_service.converter;

import com.umutyildiz.commons.DtoConverter;
import com.umutyildiz.product_service.dto.ProductDto;
import com.umutyildiz.product_service.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter implements DtoConverter<ProductDto, Product> {

    @Override
    public List<ProductDto> toDto(List<Product> list) {
        return list.stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }
}
