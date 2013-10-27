package com.kostiushko.springTestTask.jsr303.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kostiushko.springTestTask.domain.User;

@Service("myBeanValidationService")
public class MyBeanValidationService {
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<User>> validateUser(User user) {
	return validator.validate(user);
    }
}
