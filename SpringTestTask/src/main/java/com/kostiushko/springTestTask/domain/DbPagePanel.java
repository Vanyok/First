package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

public class DbPagePanel {

    private ArrayList<User> users;

    private User newUser;
    private String name;
    private Integer age;
    private Integer id;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public User getNewUser() {
	newUser = new User();
	newUser.setAge(age);
	newUser.setId(id);
	newUser.setName(name);
	return newUser;
    }

    public void setNewUser(User newUser) {
	this.newUser = newUser;
    }

    public ArrayList<User> getUsers() {
	return users;
    }

    public void setUsers(ArrayList<User> users) {
	this.users = users;
    }

    @Override
    public String toString() {
	return "DbPagePanel [users=" + users + ", newUser=" + newUser + "]";
    }

}
