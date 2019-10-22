package com.tyq.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tyq.dto.User;

@Repository
public class UserDao {

	private static Map<Integer, User> map = new HashMap<Integer, User>();

	//预先在map里存放一点数据
	static {
		map.put(1001, new User(1001,"jackma","jack",55));
		map.put(1002, new User(1002,"ponyma","pony",48));
		map.put(1003, new User(1003,"redmi","hongmi",1));
	}
	
	//保存用户
	public void save(User godMan) {
		map.put(godMan.getId(), godMan);
		System.out.println("数据库中：" + godMan);
	}
	
	
	//获取所有的用户
	public Collection<User> getUsers() {
		return map.values();
		
	}

}
