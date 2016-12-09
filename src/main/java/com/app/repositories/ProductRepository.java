package com.app.repositories;

import com.app.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by phitien on 8/12/16.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
