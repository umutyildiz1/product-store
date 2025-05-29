package com.umutyildiz.store_service.client.response;

import com.umutyildiz.store_service.client.dto.ClientProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientGetProductByBarcodeResponse {

    private List<ClientProductDto> products;

}
