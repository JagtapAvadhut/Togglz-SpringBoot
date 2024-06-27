package com.example.togglzDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductRepo productRepo;


    @Autowired
    FeatureManager featureManager;

    @GetMapping("/foo")
    public Product getProduct(){
        Product product = new Product();
        product.setProductName("Cool Product");

        if(featureManager.isActive(FeatureFlags.PRICE_INCREASE)){
            product.setProductPrice(99.9);
        } else {
            product.setProductPrice(9.99);
        }

        return productRepo.save(product);
    }

}
