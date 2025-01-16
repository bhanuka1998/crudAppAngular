package com.example.curdAppAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curdAppAngular.model.Product;
import com.example.curdAppAngular.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productRepository.findById(id).map(updatedProduct -> {
            updatedProduct.setProductName(product.getProductName());
            updatedProduct.setProductPrice(product.getProductPrice());
            return productRepository.save(updatedProduct);
        }).orElseThrow(() -> new RuntimeException("Item Not Found"));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}
