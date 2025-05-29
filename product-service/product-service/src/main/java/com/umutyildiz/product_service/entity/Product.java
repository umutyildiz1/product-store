package com.umutyildiz.product_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_generator")
    private String productId;
    @Column
    private String name;
    @Column
    private String barcode;//todo add index
    @Column
    private Integer quantity;

}
