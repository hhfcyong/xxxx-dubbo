package com.oauth.facade;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * OuPerson
 * @author zhangyong
 *
 */
@Data
public class OURegisterRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -2573653442241386778L;
    
	
	@JsonProperty("login_name")
	public String uid;

	@JsonProperty("user_name")
	public String sn;
	
	@JsonProperty("user_password")
	public String password;
	
	@JsonProperty("mobile")
	public String mobile;
	
	@JsonProperty("company")
	public String company;
	
	@JsonProperty("region_name")
	public String regionName;
	
	@JsonProperty("department")
	public String department;
	
	@JsonProperty("employee_type")
	public String employeeType;
}
