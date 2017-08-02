package com.demo.dubbo.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.dubbo.api.CommonInterface;
import com.demo.dubbo.server.interfaces.TestRepository;
import com.demo.dubbo.server.model.Test;

@Component
@Service(version = "1.0.0")
public class CommonInterfaceImple implements CommonInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterfaceImple.class);

	@Autowired
	TestRepository repository;

	@Override
	public String getFullName(String name) {
		List<Test> tests = repository.findAll();

		Test target = null;
		for (Test test : tests) {
			if (test.getTestName().equals(name.trim())) {
				target = test;
				break;
			}
		}
		logger.info("===========>run PersonServiceImpl getFullName..");
		return "getFullName:" + (null == target ? "null" : target.toString());
	}

	@Override
	public String getNickName(int id) {
		Test target = repository.findById(id);
		logger.info("===========>run PersonServiceImpl getNickName..");
		return "getNickName:" + (null == target ? "null" : target.toString());
	}


}
