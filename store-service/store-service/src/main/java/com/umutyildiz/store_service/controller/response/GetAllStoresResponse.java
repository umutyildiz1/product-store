package com.umutyildiz.store_service.controller.response;

import com.umutyildiz.store_service.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllStoresResponse {

    private List<StoreDto> stores;

}

