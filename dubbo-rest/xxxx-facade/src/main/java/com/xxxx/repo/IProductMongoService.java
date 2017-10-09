package com.xxxx.repo;


import com.xxxx.jpa.domain.Product;

public interface IProductMongoService {
    public Product getProductById(int productId);
    public void insertProduct(Product product);
    public void deleteProduct(int productId);
}
