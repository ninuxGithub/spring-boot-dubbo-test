package com.demo.dubbo.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.dubbo.api.IPerson;
import com.demo.dubbo.server.interfaces.TestRepository;
import com.demo.dubbo.server.model.Test;

@Component
@Service(version = "1.0.0")
public class PersonServiceImpl implements IPerson {

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

		return "getFullName:" + (null == target ? "null" : target.toString());
	}

	@Override
	public String getNickName(int id) {
		Test target = repository.findById(id);
		return "getNickName:" + (null == target ? "null" : target.toString());
	}
}
