package com.xxxx.restservice;


import com.xxxx.mybatis.domain.Product;

public interface IProductRestService {
	  public Product getProductById(int productId);
	  public void insertProduct(Product product);
	  public void deleteProduct(int productId);
}
