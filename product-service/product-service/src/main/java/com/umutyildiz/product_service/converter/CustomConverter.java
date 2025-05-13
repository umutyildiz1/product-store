package com.umutyildiz.product_service.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomConverter implements DtoConverter<String,String>{ //Todo it will be deleted
    @Override
    public List<String> toDto(List<String> list) {
        log.info("Custom Converter is running");
        return null;
    }
}
