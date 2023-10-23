package com.example.grocery.service;

import com.example.grocery.model.Product;
import com.example.grocery.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl {

    // productRepository constructor injection
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }


    public void order(List<Product> products, Long id) {
        productRepository.saveAll(products);
    }
}
