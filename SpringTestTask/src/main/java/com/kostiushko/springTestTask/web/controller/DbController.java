package com.kostiushko.springTestTask.web.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kostiushko.springTestTask.domain.Book;
import com.kostiushko.springTestTask.domain.DbPagePanel;
import com.kostiushko.springTestTask.domain.User;
import com.kostiushko.springTestTask.domain.UsersStorage;
import com.kostiushko.springTestTask.service.CollectionStorage;

@RequestMapping("/DB")
@Controller
@ComponentScan("com.kostiushko.springTestTask.service")
public class DbController {

    UsersStorage storage = CollectionStorage.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Model uiModel) {

	DbPagePanel dbPanel = new DbPagePanel();
	dbPanel.setUsers(storage.getAllUsers());
	uiModel.addAttribute("dbPanel", dbPanel);
	return "DB/DbPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(
	    @ModelAttribute("dbPanel") DbPagePanel dbPagePanel,
	    BindingResult bindingResult, Model uiModel,
	    HttpServletRequest httpServletRequest,
	    RedirectAttributes redirectAtributes, Locale locale) {
	User user = dbPagePanel.getNewUser();
	user.setBooks(new ArrayList<Book>());
	user.setId(storage.getSize() + 1);
	storage.addUser(user);
	System.out.println("User " + user + " was created");
	return listUsers(uiModel);
    }
}
