package com.ldap.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldap.model.rest.OUHierarchyResponse;
import com.ldap.model.rest.OUPersonRequest;
import com.ldap.model.rest.OURegisterRequest;
import com.ldap.model.rest.OURequest;
import com.ldap.model.rest.OrganizationRequest;
import com.ldap.service.OUPersonService;
import com.ldap.service.OUService;
import com.ldap.service.OrganizationService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:/META-INF/spring/**.xml" }) 
public class LdapServiceTest {
	
	@Autowired
	OrganizationService organizationService;
	@Autowired
	OUService oUService;
	
	@Autowired
	OUPersonService oUPersonService;
//    @Test
//    public void addLdapTest(){
//    	OrganizationRequest request=new OrganizationRequest();
//    	request.setOrganizationName("RegistrationCenter");
//    	request.setDomainName("moni.com");
//    	organizationService.addOrganization(request);
//    }
//	@Test
//    public void delLdapTest(){
//    	//organizationService.delOrganization("大众点评");
//		System.out.println(oUService.delOU("ou=财务部,o=用友超客"));
//    }
//    @Test
//    public void searchLdapTest(){
//    	List<Person> person1=ldapPersonService.getPerson("zhangsan", "");
//    	Person person=person1.get(0);
//    	System.out.println(person.getCn()+"  "+person.getUserPassword());
//    }
//	@Test
//	public void addOuName(){
//		OURequest oURequest=new OURequest();
//		oURequest.setRdn("o=registrationcenter");
//		oURequest.setOUName("personnelinformation");
//		oUService.addOU(oURequest);
//	}
//	@Test
//	public void addOUPerson(){
//		OUPersonRequest request=new OUPersonRequest();
//		request.setRdn("ou=技术研发部,o=用友超客");
//		request.setCn("qipangzi1");
//		request.setPassword("channel");
//		request.setMobile("123456");
//	System.out.println(oUPersonService.addOUPerson(request));
//	}
//	@Test
//	public void moveOUPerson(){
//		String oldrdn="cn=zy7,ou=财务部,o=用友超客";
//		String newrdn="cn=zy7,ou=a,dc=chao";
//		oUPersonService.moveOUPerson(oldrdn, newrdn);
//	}
	@Test
	public void addOURegister(){
		OURegisterRequest ou=new OURegisterRequest();
		ou.setUid("defaultuser");
		ou.setPassword("defaultuser");
		ou.setSn("默认用户");
		ou.setCompany("无");
		ou.setDepartment("无");
		ou.setEmployeeType("无");
		ou.setRegionName("郁南县");
		oUPersonService.addOURegister(ou);
	}
//	@Test 
//	public void findPerson(){
//		System.out.println(oUPersonService.getOUPerson("zhangsan3", ""));
//		System.out.println(oUPersonService.getRdn("zhangsan3"));
//		List<OUHierarchyResponse> lists=oUPersonService.getNextOUHierarchy("ou=personnelinformation,o=registrationcenter");
//		System.out.println(lists);
//	}
}
