package com.xxxx.repo.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxxx.mybatis.IDao.EnterpriseMapper;
import com.xxxx.mybatis.domain.Enterprise;
import com.xxxx.repo.IEnterpriseService;


@Service("enterpriseService")
public class EnterpriseServiceImpl implements IEnterpriseService{

	@Resource
	private  EnterpriseMapper enterpriseMapper;
	
	@Override
	public Enterprise getEnterpriseById(int enterpriseId) {
		return enterpriseMapper.selectByPrimaryKey(enterpriseId);
	}

}
