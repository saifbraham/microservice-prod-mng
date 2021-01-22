package org.braham.productmanagement.repository;

import org.braham.productmanagement.model.entity.Product;
import org.braham.productmanagement.model.entity.ProductLabelPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    @RestResource(rel = "FindByLabel", path="findByLabel")
   Page<Product> findByLabelIgnoreCase(@Param("label") String label,Pageable page);

    @RestResource(rel = "FindByLabelContains", path="findByLabelContains")
   Page<Product> findByLabelIgnoreCaseContains(@Param("label") String label,Pageable page);


    @RestResource(rel = "FindByQty", path="findByQty")
    Page<Product> findByQty(@Param("qty") Integer qty,Pageable page);

    @RestResource(rel = "FindByPrice", path="findByPrice")
    Page<Product> findByPrice(@Param("price") double price,Pageable page);

    @RestResource(rel = "FindByReference", path="findByReference")
    Page<Product> findByReferenceIgnoreCase(@Param("reference") String reference,Pageable page);

    @RestResource(rel = "FindByReferenceContains", path="findByReferenceContains")
    Page<Product> findByReferenceIgnoreCaseContains(@Param("reference") String reference,Pageable page);



}
