package com.kostiushko.spH.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kostiushko.spH.dao.UserDAO;
import com.kostiushko.spH.domain.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    private Log log = LogFactory.getLog(UserDAOImpl.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
	sessionFactory.getCurrentSession().saveOrUpdate(user);
	log.info("user saved with id: " + user.getId());
    }

    public void deleteUser(User user) {
	sessionFactory.getCurrentSession().delete(user);
	log.info("User deleted with id: " + user.getId());

    }

    public void updateUser(User user) {
	sessionFactory.getCurrentSession().update(user);
	log.info("User whith id: " + user.getId() + "was updated");

    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
	return (User) sessionFactory.getCurrentSession()
		.getNamedQuery("User.findById").setParameter("id", id)
		.uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
	return sessionFactory.getCurrentSession().createQuery("from User c")
		.list();
    }

}
