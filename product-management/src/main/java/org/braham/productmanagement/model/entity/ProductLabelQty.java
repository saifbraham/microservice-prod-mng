package org.braham.productmanagement.model.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "labelqty",types = {Product.class})
public interface ProductLabelQty {
    String getLabel();
    Integer getQty();
}
