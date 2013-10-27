package com.kostiushko.springTestTask.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.kostiushko.springTestTask.domain.User;
import com.kostiushko.springTestTask.jsr303.service.MyBeanValidationService;

public class Jsr303Validator {

    MyBeanValidationService validationService = null;
    ArrayList<String> errorsList;

    public Jsr303Validator() {
	createValidationService();
    }

    private void createValidationService() {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:jsr303-app-context.xml");
	ctx.refresh();

	validationService = ctx.getBean("myBeanValidationService",
		MyBeanValidationService.class);

    }

    public ArrayList<String> validate(User user) {

	Set<ConstraintViolation<User>> violations = new HashSet<ConstraintViolation<User>>();
	violations = validationService.validateUser(user);
	errorsList = new ArrayList<String>();
	for (ConstraintViolation<User> violation : violations) {
	    String message = "Error : " + violation.getPropertyPath()
		    + " with value: " + violation.getInvalidValue()
		    + " because : " + violation.getMessage();
	    errorsList.add(message);
	}
	return errorsList;
    }
}
