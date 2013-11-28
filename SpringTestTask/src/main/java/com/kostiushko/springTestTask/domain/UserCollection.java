package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

public class UserCollection {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
	return users;
    }

    public void setUsers(ArrayList<User> users) {
	this.users = users;
    }

    @Override
    public String toString() {
	return "UserCollection [users=" + users + "]";
    }
}
