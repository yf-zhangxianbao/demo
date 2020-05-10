package com.example.test.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.TestMapper;
import com.example.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper tm;

	@Override
	public Map<String,Object> selectCount() {
		return tm.selectCount();
	}

}
