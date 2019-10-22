package com.tyq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tyq.dao.UserDao;
import com.tyq.dto.User;

@Controller
@RequestMapping("identity")
public class userController {

	// 自动装配
	@Autowired
	private UserDao userDao;
	
	//用户首页，显示用户信息
	@RequestMapping("user")
	public ModelAndView userMain(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("identity/user/index");
		map.put("user", userDao.getUsers());
		return mav;
	}
	
	//跳转至添加用户的界面
	@RequestMapping("add")
	public ModelAndView AddUser() {
		ModelAndView mav = new ModelAndView("identity/user/add");
		return mav;
	}
	
	//保存操作
	@RequestMapping("save")
	public ModelAndView save(User godMan, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("identity/user/index");
		System.out.println(godMan);
		
		//这里省略service层，直接调用dao层保存数据
		userDao.save(godMan);
		//调用方法获取所有的用户数据，并写入map中
		map.put("user", userDao.getUsers());
		
		return mav;
	}
}
