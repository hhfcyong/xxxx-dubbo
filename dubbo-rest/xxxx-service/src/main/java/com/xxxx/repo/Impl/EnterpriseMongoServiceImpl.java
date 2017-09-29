package com.xxxx.repo.Impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxx.jpa.repo.EnterpriseRepo;
import com.xxxx.jpa.domain.Enterprise;
import com.xxxx.repo.IEnterpriseMongoService;



@Service("enterpriseMongoService")
public class EnterpriseMongoServiceImpl implements IEnterpriseMongoService{
   
	@Autowired
	EnterpriseRepo enterpriseRepo;

	@Override
	public Enterprise getEnterpriseById(int enterpriseId) {
		// TODO Auto-generated method stub
		return enterpriseRepo.findOne(enterpriseId);
	}

	@Override
	public void insertEnterprise(Enterprise enterprise) {
		// TODO Auto-generated method stub
		enterpriseRepo.save(enterprise);
	}

	@Override
	public void deleteEnterprise(int enterpriseId) {
		// TODO Auto-generated method stub
		enterpriseRepo.delete(enterpriseId);
	}



}
