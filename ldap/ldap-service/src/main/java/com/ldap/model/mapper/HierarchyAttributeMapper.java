package com.ldap.model.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.ldap.model.rest.OUHierarchyResponse;
import com.ldap.model.rest.OUPersonResponse;

public class HierarchyAttributeMapper implements AttributesMapper{  
	  
    @Override  
    public Object mapFromAttributes(Attributes attr) throws NamingException {  
    	OUHierarchyResponse person = new OUHierarchyResponse();  
       
        if (attr.get("sn") != null) {  
            person.setSn((String)attr.get("sn").get());  
        }  
        if (attr.get("cn") != null) {  
            person.setCn((String)attr.get("cn").get());  
        }
        return person;  
    }  
  
}  
