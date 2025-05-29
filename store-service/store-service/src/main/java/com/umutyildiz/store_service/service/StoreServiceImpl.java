package com.umutyildiz.store_service.service;

import com.umutyildiz.commons.DtoConverter;
import com.umutyildiz.store_service.client.ProductServiceClient;
import com.umutyildiz.store_service.controller.request.AddProductToStoreRequest;
import com.umutyildiz.store_service.controller.request.CreateStoreRequest;
import com.umutyildiz.store_service.controller.response.GetAllStoresResponse;
import com.umutyildiz.store_service.dto.StoreDto;
import com.umutyildiz.store_service.entity.Store;
import com.umutyildiz.store_service.exception.StoreNotFoundException;
import com.umutyildiz.store_service.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository repository;
    private final ProductServiceClient productServiceClient;
    private final DtoConverter<StoreDto, Store> converter;

    @Override
    public GetAllStoresResponse getStores() {
        final var stores = repository.findAll();
        return GetAllStoresResponse.builder()
                .stores(converter.toDto(stores))
                .build();
    }

    @Override
    public void createStore(CreateStoreRequest request) {
        repository.save(
                Store.builder()
                        .name(request.getName())
                        .build()
        );
    }

    @Override
    public void addProductToStore(AddProductToStoreRequest request) {
        var store = getStoreByName(request.getStoreName());
        var product = productServiceClient.getProduct(request.getProductName());

        store.getProductBarcodes().add(product.getBarcode());
        repository.save(store);
    }

    private Store getStoreByName(String name) {
        var store = repository.getStoreByName(name);
        return store.orElseThrow(() -> new StoreNotFoundException(String.format("Store not found with name : %s", name)));
    }


}
