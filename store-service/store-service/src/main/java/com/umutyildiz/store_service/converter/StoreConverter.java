package com.umutyildiz.store_service.converter;

import com.umutyildiz.commons.DtoConverter;
import com.umutyildiz.store_service.client.ProductServiceClient;
import com.umutyildiz.store_service.client.dto.ClientProductDto;
import com.umutyildiz.store_service.client.request.ClientGetProductByBarcodeRequest;
import com.umutyildiz.store_service.dto.StoreDto;
import com.umutyildiz.store_service.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class StoreConverter implements DtoConverter<StoreDto, Store> {

    private final DtoConverter<String, ClientProductDto> productDtoConverter;
    private final ProductServiceClient productServiceClient;

    @Override
    public List<StoreDto> toDto(List<Store> list) {
        return Optional.ofNullable(list).orElse(emptyList())//todo bunu parallel stream ile async hale getir
                .stream()
                .map(store -> {
                    var storeDto = StoreDto.convert(store);
                    Optional.ofNullable(store.getProductBarcodes())
                            .stream()
                            .filter(barcodes -> !barcodes.isEmpty())
                            .map(barcodes -> ClientGetProductByBarcodeRequest.builder()
                                    .barcodes(barcodes)
                                    .build())
                            .map(productServiceClient::getProductsByBarcode)
                            .map(response -> productDtoConverter.toDto(response.getProducts()))
                            .findAny()
                            .ifPresent(storeDto::setProducts);
                    return storeDto;
                })
                .collect(Collectors.toList());
    }
}
