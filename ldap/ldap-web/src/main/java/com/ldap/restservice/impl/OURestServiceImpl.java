package com.ldap.restservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.ldap.model.rest.OURequest;
import com.ldap.restservice.OURestService;
import com.ldap.service.OUService;

@Path("/usercenter/ou")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
@Service("oURestService")
public class OURestServiceImpl implements OURestService {

	@Autowired
	private OUService oUService;
	
	@POST
	@Path("create")
	@Override
	public String addOU(OURequest oURequest) {
		return oUService.addOU(oURequest);
	}

	@DELETE
	@Path("delete")
	@Override
	public String delOU(String rdn) {
		return oUService.delOU(rdn);
	}

}
