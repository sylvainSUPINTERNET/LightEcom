package org.sid.lightecomv1.dao;

import org.sid.lightecomv1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    //par defaut Spring data a deja fait plein de méthod
    // Spring data REST

    //search c'est pour les méthodes findBy dans Spring data
    //Spring data => pour y accéder /products/search/<method_find_by_XX>
    @RestResource(path="/selectedProducts")
    public List<Product> findBySelectedIsTrue();


    // /localhost8080/products/search/productsByKeyword?mc="X"
    @RestResource(path="/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);

    //si on a pas d'implémentation JPA on le fait nous même
    //@Query("select p from product where p.name like :word")
    // public List<Product> chercher(@Param("word") String mc);



}

