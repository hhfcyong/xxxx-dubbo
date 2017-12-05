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

import com.xxxx.repo.ITestService;
import com.xxxx.restservice.ITestRestService;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

@Path("/")
//@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_FORM_URLENCODED })
//@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("testRestService")
public class TestRestServiceImpl implements ITestRestService {
   
	@Autowired
	ITestService testService;
	

  
	@Path("/gettest/{id}")
	@GET
	@Override
	public String getTestById(int Id) {
		// TODO Auto-generated method stub
		return testService.getTestById(Id);
	}
	@Path("/inserttest")
	@POST
	@Override
	public void insertTest() {
		// TODO Auto-generated method stub
		testService.insertTest();
	}
	@Path("/deletetest/{id}")
	@DELETE
	@Override
	public void deleteTest(int Id) {
		// TODO Auto-generated method stub
		testService.deleteTest(Id);
	}

}
