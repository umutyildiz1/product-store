package com.umutyildiz.store_service.repository;

import com.umutyildiz.store_service.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {

    @Query("select s from Store s where s.name = :name")
    Optional<Store> getStoreByName(@Param("name") String name);

}
