package org.braham.productmanagement.model.entity;



import org.springframework.data.rest.core.config.Projection;

@Projection(name = "label",types = { Product.class })
interface ProductLabel {

    String getLabel();

}

