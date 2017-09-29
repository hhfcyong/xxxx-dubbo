package com.xxxx.repo.Impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xxxx.jpa.repo.ProductRepo;
import com.xxxx.jpa.domain.Product;
import com.xxxx.repo.IProductMongoService;


@Service("productMongoService")
public class ProductMongoServiceImpl implements IProductMongoService {
  

	@Autowired
	ProductRepo productRepo;

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productRepo.findOne(productId);
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productRepo.delete(productId);
	}



}
