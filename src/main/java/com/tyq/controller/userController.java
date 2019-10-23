package com.tyq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyq.dao.UserDao;
import com.tyq.dto.User;

@Controller
@RequestMapping("identity")
public class userController {

	// 自动装配
	@Autowired
	private UserDao userDao;
	
	

	// 提供数据
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			map.put("user", userDao.get(id));
		}
	}

	// 完成修改
	@RequestMapping(value = "user", method = RequestMethod.PUT)
	public String Update(User user) {
		userDao.save(user);
		return "redirect:/identity/users";
	}

	/**
	 * 添加和修改，用的是同一个input页面，
	 * 两个相同的方法，
	 * 修改时的方法绑定了一个id参数，通过该参数找到要修改的用户并进行修改
	 * 新建时的方法，在map里传入了一个新建的user对象，通过该对象来判断是新建还是修改(新建的id为空)
	 * 
	 */
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ModelAndView input(@PathVariable("id") Integer id, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("identity/user/input");
		map.put("user", userDao.get(id));
		return mav;
	}

	// 跳转至添加用户的界面
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView input(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("identity/user/input");
		map.put("users", userDao.getUsers()); //显示所有的用户
		map.put("user", new User());
		return mav;
	}

	// 保存操作
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ModelAndView save(User godMan, Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("redirect:users");
		System.out.println(godMan);

		// 这里省略service层，直接调用dao层保存数据
		userDao.save(godMan);
		// 调用方法获取所有的用户数据，并写入map中
		map.put("user", userDao.getUsers());
		return mav;
	}

	// 删除操作
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		userDao.delete(id);
		System.out.println("删除完成");
		return "redirect:/identity/users";
	}
	
	// 用户首页，显示用户信息
	@RequestMapping("users")
	public ModelAndView userMain(Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("identity/user/index");
		map.put("user", userDao.getUsers());
		return mav;
	}
}
