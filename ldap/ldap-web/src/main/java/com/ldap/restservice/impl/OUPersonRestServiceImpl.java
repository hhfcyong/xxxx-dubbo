package com.ldap.restservice.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.ldap.model.rest.OUHierarchyRequest;
import com.ldap.model.rest.OUHierarchyResponse;
import com.ldap.model.rest.OUPersonRequest;
import com.ldap.model.rest.OUPersonResponse;
import com.ldap.model.rest.OURegisterRequest;
import com.ldap.restservice.OUPersonRestService;
import com.ldap.service.OUPersonService;

@Path("/usercenter/ouperson")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
@Service("oUPersonRestService")
public class OUPersonRestServiceImpl implements OUPersonRestService {
	@Autowired
	private OUPersonService oUPersonService;
	
	@POST
	@Path("create")
	@Override
	public String addOUPerson(OUPersonRequest oUPersonRequest) {
		return oUPersonService.addOUPerson(oUPersonRequest);
	}

	@DELETE
	@Path("delete")
	@Override
	public String delOUPerson(String rdn) {
		return oUPersonService.delOUPerson(rdn);
	}

	@POST
	@Path("register")
	@Override
	public String addOURegister(OURegisterRequest oURegisterRequest) {
		return oUPersonService.addOURegister(oURegisterRequest);
	}
    
	@GET
	@Path("account")
	@Override
	public OUPersonResponse getOUPerson(@QueryParam("login_name") String loginName,@QueryParam("user_password") String userPassword) {
		return oUPersonService.getOUPerson(loginName, userPassword);
	}

	@GET
	@Path("move")
	@Override
	public String moveOUPerson(@QueryParam("oldrdn") String oldrdn,@QueryParam("newrdn")  String newrdn) {
		return oUPersonService.moveOUPerson(oldrdn, newrdn);
	}

	@POST
	@Path("hierarchy")
	@Override
	public String addOUHierarchy(OUHierarchyRequest oUHierarchyRequest) {
		return oUPersonService.addOUHierarchy(oUHierarchyRequest);
	}

	@GET
	@Path("rdn")
	@Override
	public String getRdn(@QueryParam("login_name") String uid) {
		return oUPersonService.getRdn(uid);
	}

	@GET
	@Path("nexthierarchy")
	@Override
	public List<OUHierarchyResponse> getNextOUHierarchy(@QueryParam("rdn") String rdn) {
		return oUPersonService.getNextOUHierarchy(rdn);
	}

	@DELETE
	@Path("delhierarchy")
	@Override
	public String delOUHierarchy(@QueryParam("rdn") String rdn) {
		return oUPersonService.delOUHierarchy(rdn);
	}
}
