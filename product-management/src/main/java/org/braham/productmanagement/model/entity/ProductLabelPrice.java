package org.braham.productmanagement.model.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "labelprice",types = {Product.class})
public interface ProductLabelPrice {

    String getLabel();
    double getPrice();
}
