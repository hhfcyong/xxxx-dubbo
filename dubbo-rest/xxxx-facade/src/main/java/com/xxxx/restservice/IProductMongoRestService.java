package com.xxxx.restservice;


import com.xxxx.jpa.domain.Product;

public interface IProductMongoRestService {
	  public Product getProductById(int productId);
	  public void insertProduct(Product product);
	  public void deleteProduct(int productId);
}
