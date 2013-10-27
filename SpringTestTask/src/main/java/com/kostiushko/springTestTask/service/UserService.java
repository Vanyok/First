package com.kostiushko.springTestTask.service;

import java.util.Map;

import com.kostiushko.springTestTask.domain.User;

public interface UserService {

    public void addUser(User user);

    public Map<Integer, User> listUser();

    public void removeUser(Integer id);

    public User getUser(Integer id);
}
