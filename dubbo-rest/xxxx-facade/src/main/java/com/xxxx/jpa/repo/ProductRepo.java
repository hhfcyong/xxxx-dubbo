package com.xxxx.jpa.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xxxx.jpa.domain.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product,Integer>{

}
