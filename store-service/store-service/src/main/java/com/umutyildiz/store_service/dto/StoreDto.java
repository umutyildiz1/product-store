package com.umutyildiz.store_service.dto;

import com.umutyildiz.store_service.client.dto.ClientProductDto;
import com.umutyildiz.store_service.entity.Store;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class StoreDto {

    private String name;
    private List<String> products;

    public static StoreDto convert(Store store){
        return StoreDto.builder()
                .name(store.getName())
                .build();
    }
}
