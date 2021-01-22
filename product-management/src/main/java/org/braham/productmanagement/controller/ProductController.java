package org.braham.productmanagement.controller;

import lombok.AllArgsConstructor;
import org.braham.productmanagement.model.entity.Product;
import org.braham.productmanagement.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
//@RequestMapping("/custume")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/products/{label}")
    public List<Product> getProductByLabel(@PathVariable(value = "label") String label){


        return productService.getProductByLabel(label);
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Product> getCompanyDetails(@Valid @RequestBody Product request) {
        Product prod = new Product();
        prod.setLabel(request.getLabel());
        prod.setQty(request.getQty());
        prod.setPrice(request.getPrice());
        prod.setReference(request.getReference());
        return new ResponseEntity(prod, HttpStatus.OK);
    }


}
