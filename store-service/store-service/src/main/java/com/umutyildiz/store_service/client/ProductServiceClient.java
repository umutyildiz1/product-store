package com.umutyildiz.store_service.client;

import com.umutyildiz.store_service.client.dto.ClientProductDto;
import com.umutyildiz.store_service.client.request.ClientGetProductByBarcodeRequest;
import com.umutyildiz.store_service.client.response.ClientGetProductByBarcodeResponse;
import com.umutyildiz.store_service.configuration.FeignConfig;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${client.service.product-service.name}",
        //url = "https://localhost:8081", disable the eureka that is overrides the name
        path = "${client.service.product-service.path}",
        configuration = FeignConfig.class)
public interface ProductServiceClient {

    @GetMapping(path = "${client.service.product-service.get-products-path}")
    @NotNull List<ClientProductDto> getProducts();

    @GetMapping(path = "${client.service.product-service.get-product-by-name-path}")
    @NotNull ClientProductDto getProduct(@PathVariable("productName") String productName);

    @PostMapping(path = "${client.service.product-service.get-products-by-barcode-path}")
    @NotNull ClientGetProductByBarcodeResponse getProductsByBarcode(@RequestBody ClientGetProductByBarcodeRequest request);//@RequestBody ile Getmapping beraber kullanılmamalı hata verir.
}
