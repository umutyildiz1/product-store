package com.umutyildiz.commons;

import java.util.List;

public interface DtoConverter<T,E> {

    List<T> toDto(List<E> list);
}
