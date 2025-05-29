package com.umutyildiz.store_service.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStoreRequest {

    private String name;

}
