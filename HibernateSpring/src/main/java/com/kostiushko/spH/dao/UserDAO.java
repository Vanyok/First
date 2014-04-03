package com.kostiushko.spH.dao;

import java.util.List;

import com.kostiushko.spH.domain.User;



public interface UserDAO {

    public void addUser (User user) ;
    public void deleteUser (User user) ;
    public void updateUser (User user);
    public User getUserById (long id);
    public List<User> getAllUsers();
}
