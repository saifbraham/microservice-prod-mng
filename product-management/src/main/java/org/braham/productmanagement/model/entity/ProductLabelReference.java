package org.braham.productmanagement.model.entity;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "labelreference",types = {Product.class})
public interface ProductLabelReference {



        String getLabel();
        String getReference();


}
