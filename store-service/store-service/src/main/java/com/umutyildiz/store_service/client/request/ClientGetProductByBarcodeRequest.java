package com.umutyildiz.store_service.client.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientGetProductByBarcodeRequest {

    private List<String> barcodes;

}
