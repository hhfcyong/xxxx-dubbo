package com.xxxx.repo.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxxx.repo.ITestService;


@Service("testService")
public class TestServiceImpl implements ITestService{
	Logger  logger=Logger.getLogger(TestServiceImpl.class); 
	private static final List<Map<Integer,String>> listmap=new ArrayList<Map<Integer,String>>();
	
	

	@Override
	public String getTestById(int Id) {	
		return listmap.get(0).get(Id);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertTest() {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "test");
		listmap.add(map);
	}


	@Override
	public void deleteTest(int Id) {
		// TODO Auto-generated method stub
		listmap.clear();
	}

}
