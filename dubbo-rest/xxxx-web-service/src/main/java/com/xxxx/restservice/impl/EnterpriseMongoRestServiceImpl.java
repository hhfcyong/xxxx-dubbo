package com.xxxx.restservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.xxxx.jpa.domain.Enterprise;
import com.xxxx.repo.IEnterpriseMongoService;
import com.xxxx.restservice.IEnterpriseMongoRestService;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

@Path("/mongo")
//@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_FORM_URLENCODED })
//@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("enterpriseMongoRestService")
public class EnterpriseMongoRestServiceImpl implements IEnterpriseMongoRestService {
   
	@Autowired
	IEnterpriseMongoService enterpriseMongoService;
	

    
	@Path("/getenterprise/{id}")
	@GET
	@Override
	public Enterprise getEnterpriseById(@PathParam("id") int id) {
		// TODO Auto-generated method stub
		return enterpriseMongoService.getEnterpriseById(id);
	}
	@Path("/insertenterprise")
	@POST
	@Override
	public void insertEnterprise(@RequestBody Enterprise enterprise) {
		// TODO Auto-generated method stub
	
		enterpriseMongoService.insertEnterprise(enterprise);
	}
	@Path("/getstring/{name}")
	@GET
	@Override
	public String getString(@PathParam("name") String name) {
		// TODO Auto-generated method stub
		return name;
	}
	@Path("/deleteenterprise/{id}")
	@DELETE
	@Override
	public void deleteEnterprise(@PathParam("id") int enterpriseId) {
		// TODO Auto-generated method stub
		enterpriseMongoService.deleteEnterprise(enterpriseId);
	}

}
