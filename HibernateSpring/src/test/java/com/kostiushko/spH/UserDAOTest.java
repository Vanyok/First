package com.kostiushko.spH;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kostiushko.spH.dao.UserDAO;
import com.kostiushko.spH.domain.User;

public class UserDAOTest {

    private UserDAO userDAO;
    private User testUser;
    private User updatedUser;

    @Before
    public void setUpBeforeClass() throws Exception {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:app-context.xml");
	ctx.refresh();

	userDAO = ctx.getBean("userDAO", UserDAO.class);

	testUser = setTestUser("test name", "test login" , 18, "test password");
	updatedUser = setTestUser("test name", "test login" , 18, "updated password");
	
	System.out.println("test user " + testUser + " was created");

    }

    @Test
    public void allMethodsUserDAOTest() {
	userDAO.addUser(testUser);
	System.out.println("user was added");
	System.out.println(userDAO.getAllUsers());
	assertEquals(1, userDAO.getAllUsers().size());
   	assertEquals(testUser, userDAO.getUserById(1));
   	User userForUpdate = userDAO.getUserById(1);
   	userForUpdate.setPassword("updated password");
   	userDAO.updateUser(userForUpdate);
   	assertEquals(updatedUser, userDAO.getUserById(1));
   	userDAO.deleteUser(userForUpdate);
   	assertEquals(null, userDAO.getUserById(1));
    }

    private User setTestUser(String name, String login, int age, String password) {
	System.out.println("set user start");
	User user = new User();
	user.setAge(age);
	user.setLogin(login);
	user.setName(name);
	user.setPassword(password);
	return user;
    }

}
