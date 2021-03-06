package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.dubbo.api.CommonInterface;

@RestController
public class UserController {

	@Reference(version = "1.0.0", check = false)
	CommonInterface commonInterface;

	@RequestMapping("/{id}")
	public String view(@PathVariable("id") int id) {
		String result = commonInterface.getNickName(id);
		return result;
	}

	@RequestMapping("/info/{name}")
	public String view(@PathVariable("name") String name) {
		String result = commonInterface.getFullName(name);
		return result;
	}
}
