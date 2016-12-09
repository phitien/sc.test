package com.app.controllers;

import com.app.repositories.ProductRepository;
import com.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by phitien on 8/12/16.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class ProductController extends AbstractRestController {

    @Autowired
    ProductService productService;

    @RequestMapping("/price/{productId}")
    public Map<String, Object> getPrice(@PathVariable Long productId) throws Exception {
        return put("price", productService.getPrice(productId))
                .setSuccess()
                .getResponse();
    }
}
