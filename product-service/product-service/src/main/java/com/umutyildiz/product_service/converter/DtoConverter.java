package com.umutyildiz.product_service.converter;

import java.util.List;

public interface DtoConverter<T,E> {

    List<T> toDto(List<E> list);
}
