package org.braham.productmanagement.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max = 50)
    private String label;
    private Integer qty;
    private double price;
    private double lastPrice;
    private String description;
    private String reference;
    @NotNull
    @Size(min=4, max=20)
    @Column(unique = true)
    private String referenceLowerCase;
    @PrePersist @PreUpdate private void prepare(){
        this.referenceLowerCase = reference == null ? null : reference.toLowerCase();
    }

    private boolean promotion;

    public Product(Long id, @NotBlank @Size(min = 2, max = 50) String label, @NotNull @Size(min = 4, max = 20) String reference) {
        this.id = id;
        this.label = label;
        this.reference = reference;
    }

    public Product(Long id, @NotBlank @Size(min = 2, max = 50) String label, Integer qty, double price, @NotNull @Size(min = 4, max = 20) String reference) {
        this.id = id;
        this.label = label;
        this.qty = qty;
        this.price = price;
        this.reference = reference;
    }

    public void setPrice(double price) {
        this.lastPrice=this.price;
        this.price = price;
    }

}
