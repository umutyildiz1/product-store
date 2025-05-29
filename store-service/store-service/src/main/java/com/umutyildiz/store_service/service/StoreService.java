package com.umutyildiz.store_service.service;

import com.umutyildiz.store_service.controller.request.AddProductToStoreRequest;
import com.umutyildiz.store_service.controller.request.CreateStoreRequest;
import com.umutyildiz.store_service.controller.response.GetAllStoresResponse;

public interface StoreService {

    GetAllStoresResponse getStores();
    void createStore(CreateStoreRequest request);

    void addProductToStore(AddProductToStoreRequest request);

}
