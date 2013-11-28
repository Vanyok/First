package com.kostiushko.springTestTask.service;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.kostiushko.springTestTask.domain.User;
import com.kostiushko.springTestTask.domain.UserCollection;
import com.kostiushko.springTestTask.domain.UsersStorage;

public class CollectionStorage implements UsersStorage {

    private UserCollection collection;

    private CollectionStorage() {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:\\Collection-app-context.xml");
	ctx.refresh();

	collection = (UserCollection) ctx.getBean("userCollection");
	ctx.close();
	users = collection.getUsers();
    }

    private static CollectionStorage storage;

    public static CollectionStorage getInstance() {
	if (storage == null) {
	    storage = new CollectionStorage();
	}
	return storage;
    }

    private ArrayList<User> users;

    @Override
    public boolean addUser(User user) {
	if (user == null || users.contains(user)) {
	    return false;
	}
	users.add(user);
	return true;
    }

    @Override
    public ArrayList<User> getAllUsers() {

	return users;
    }

    @Override
    public boolean removeUser(User user) {
	if (users.contains(user)) {
	    users.remove(user);
	    return true;
	}
	return false;
    }

    public User getUser(Integer id) {
	for (User user : users) {
	    if (user.getId() == id) {
		return user;
	    }
	}
	return null;

    }

    public void removeUser(Integer id) {
	users.remove(getUser(id));

    }

    public Integer getSize() {
	return users.size();
    }
}
