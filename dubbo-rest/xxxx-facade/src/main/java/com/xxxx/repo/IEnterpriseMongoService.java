package com.xxxx.repo;

import com.xxxx.jpa.domain.Enterprise;

public interface IEnterpriseMongoService {
     public Enterprise getEnterpriseById(int enterpriseId);
     public void insertEnterprise(Enterprise enterprise);
     public void deleteEnterprise(int enterpriseId);
}
