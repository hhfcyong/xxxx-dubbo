package com.xxxx.restservice;

import com.xxxx.jpa.domain.Enterprise;

public interface IEnterpriseMongoRestService {
	  public Enterprise getEnterpriseById(int id);
	  public void insertEnterprise(Enterprise enterprise);
	  public String getString(String name);
	  public void deleteEnterprise(int enterpriseId);
}
