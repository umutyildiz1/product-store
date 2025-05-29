package com.umutyildiz.product_service.repository;

import com.umutyildiz.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findProductByBarcode(String barcode);

    @Query("select p from Product p where p.barcode in :barcodes")
    Optional<List<Product>> findProductsByBarcode(@Param("barcodes") List<String> barcodes);

    Optional<Product> findProductByName(String name);
}
