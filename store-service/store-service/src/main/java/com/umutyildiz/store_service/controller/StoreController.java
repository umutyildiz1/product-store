package com.umutyildiz.store_service.controller;

import com.umutyildiz.store_service.controller.request.AddProductToStoreRequest;
import com.umutyildiz.store_service.controller.request.CreateStoreRequest;
import com.umutyildiz.store_service.controller.response.GetAllStoresResponse;
import com.umutyildiz.store_service.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@Validated
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @GetMapping("/all")
    public ResponseEntity<GetAllStoresResponse> getStores(){
        return new ResponseEntity<>(service.getStores(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createStore(@RequestBody @Valid CreateStoreRequest request){
        service.createStore(request);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody @Valid AddProductToStoreRequest request){
        service.addProductToStore(request);
    }
}
