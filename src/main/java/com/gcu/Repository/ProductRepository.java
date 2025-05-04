package com.gcu.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.Entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{
    
}
