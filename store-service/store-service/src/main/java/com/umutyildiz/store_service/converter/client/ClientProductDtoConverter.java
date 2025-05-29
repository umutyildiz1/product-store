package com.umutyildiz.store_service.converter.client;

import com.umutyildiz.commons.DtoConverter;
import com.umutyildiz.store_service.client.dto.ClientProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
public class ClientProductDtoConverter implements DtoConverter<String, ClientProductDto> {
    @Override
    public List<String> toDto(List<ClientProductDto> list) {
        return Optional.ofNullable(list).orElse(emptyList())
                .stream()
                .map(ClientProductDto::getName)
                .collect(Collectors.toList());
    }
}
