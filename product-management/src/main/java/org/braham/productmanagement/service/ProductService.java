package org.braham.productmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.braham.productmanagement.model.entity.Product;
import org.braham.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductByLabel(String label){
        List<Product> listProductByLabel =  productRepository.findAll()
                .stream()
                .filter(p->p.getLabel().equals(label))
                .collect(Collectors.toList());
        log.info("Liste products by label : "+ listProductByLabel);

        return listProductByLabel;
    }
}
