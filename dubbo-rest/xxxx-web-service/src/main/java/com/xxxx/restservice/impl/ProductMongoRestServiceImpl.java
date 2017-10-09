package com.xxxx.restservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.xxxx.jpa.domain.Product;
import com.xxxx.repo.IProductMongoService;
import com.xxxx.restservice.IProductMongoRestService;


@Path("/mongo/product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("productMongoRestService")
public class ProductMongoRestServiceImpl implements IProductMongoRestService {

	@Autowired
	IProductMongoService productMongoService;
	
	@Path("/getproduct/{productId}")
	@GET
	@Override
	public Product getProductById(@PathParam("productId") int productId) {
		// TODO Auto-generated method stub
		return productMongoService.getProductById(productId);
	}
    
	@Path("/insertproduct")
	@POST
	@Override
	public void insertProduct(@RequestBody Product product) {
		productMongoService.insertProduct(product);
	}

	@Path("/deleteproduct/{productId}")
	@DELETE
	@Override
	public void deleteProduct(@PathParam("productId") int productId) {
		productMongoService.deleteProduct(productId);
	}

}
