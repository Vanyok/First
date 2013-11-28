package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

public interface UsersStorage {

    public boolean addUser(User user);

    public ArrayList<User> getAllUsers();

    public boolean removeUser(User user);

    public Integer getSize();

    public User getUser(Integer id);

    public void removeUser(Integer id);

}
