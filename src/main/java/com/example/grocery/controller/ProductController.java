package com.example.grocery.controller;

import com.example.grocery.model.Product;
import com.example.grocery.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // productService constructor injection
    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value = {"/userPage/all"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = {"/adminPage/saveAll"})
    public void saveAll(List<Product> productList) {
         productService.saveAll(productList);
    }

    @DeleteMapping(value = {"/adminPage/delete"})
    public void saveAll(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping(value = {"/adminPage/update"})
    public void save(Product product){
        productService.save(product);
    }

    @PostMapping(value = {"/userPage/order"})
    public void order(List<Product> products,Long id){
        productService.order(products,id);
    }


}
