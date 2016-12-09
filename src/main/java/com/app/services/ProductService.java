package com.app.services;

import com.app.exceptions.ProductNotFound;
import com.app.models.Product;
import com.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by phitien on 8/12/16.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Float getPrice(Long id) throws Exception {
        Product product = productRepository.findOne(id);
        if (product == null) throw new ProductNotFound();
        return product.calculatePrice();
    }
}
