package com.xxxx.repo.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxxx.mybatis.IDao.ProductMapper;
import com.xxxx.mybatis.domain.Product;
import com.xxxx.repo.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
  
	@Resource
	private ProductMapper productMapper;
	
	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(productId);
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productMapper.insert(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productMapper.deleteByPrimaryKey(productId);
	}

}
