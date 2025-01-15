package com.example.curdAppAngular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curdAppAngular.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
