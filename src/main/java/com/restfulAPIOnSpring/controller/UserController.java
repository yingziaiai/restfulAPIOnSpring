package com.restfulAPIOnSpring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restfulAPIOnSpring.vo.UserVO;

//http://download.csdn.net/download/kaixinkuaikuailai/9426629
//springMVC整合FastJson实现RestFul风格API  

@Controller
@RequestMapping("/v1/users")
public class UserController {

	private static List<UserVO> lists = null;

	static {
		lists = new ArrayList<UserVO>();
		UserVO user = new UserVO();
		user.setId("1");
		user.setName("中文");
		UserVO user2 = new UserVO();
		user2.setId("2");
		user2.setName("英文");
		lists.add(user);
		lists.add(user2);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserVO> listUser() {
		return lists;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserVO findUserById(@PathVariable("id") String id) {
		for (UserVO userVO : lists) {
			if (userVO.getId().equals(id)) {
				return userVO;
			}
		}
		return new UserVO();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserVO insertUser() {
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public UserVO updateUser(@PathVariable("id") String id) {
		return null;
	}
}

