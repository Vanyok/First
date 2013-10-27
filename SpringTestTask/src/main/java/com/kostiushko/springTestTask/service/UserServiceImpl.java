package com.kostiushko.springTestTask.service;

import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.kostiushko.springTestTask.domain.User;

public class UserServiceImpl implements UserService {

    private Map<Integer, User> userBase;

    public Map<Integer, User> getUserBase() {
	return userBase;
    }

    public void setUserBase(Map<Integer, User> userBase) {
	this.userBase = userBase;
    }

    @Override
    public void addUser(User user) {
	userBase.put(user.getId(), user);
    }

    @Override
    public Map<Integer, User> listUser() {
	return userBase;
    }

    @Override
    public void removeUser(Integer id) {
	userBase.remove(id);
    }

    @Override
    public User getUser(Integer id) {
	return userBase.get(id);

    }

    public static void main(String[] args) {

	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:app-context-xml.xml");
	ctx.refresh();

	UserService instance = (UserService) ctx.getBean("userService");
	System.out.println(instance.listUser());
	ctx.close();
    }

}
