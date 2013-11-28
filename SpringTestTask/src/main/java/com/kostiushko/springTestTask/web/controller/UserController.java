package com.kostiushko.springTestTask.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kostiushko.springTestTask.domain.Book;
import com.kostiushko.springTestTask.domain.BookArhive;
import com.kostiushko.springTestTask.domain.BookList;
import com.kostiushko.springTestTask.domain.User;
import com.kostiushko.springTestTask.service.CollectionStorage;
import com.kostiushko.springTestTask.service.Jsr303Validator;

@RequestMapping("/users")
@Controller
@ComponentScan("com.kostiushko.springTestTask.service")
public class UserController {

    private Jsr303Validator validator = new Jsr303Validator();
    private CollectionStorage storage;

    public UserController() {

	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:\\app-context-xml.xml");
	ctx.refresh();

	storage = CollectionStorage.getInstance();
	bookArhive = (BookArhive) ctx.getBean("arhiveBook");

	ctx.close();
    }

    private BookArhive bookArhive;

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Model uiModel) {

	Collection<User> users = storage.getAllUsers();
	uiModel.addAttribute("users", users);

	return "users/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Integer id, Model uiModel) {

	User user = storage.getUser(id);
	BookList books = new BookList();
	books.setBookList((ArrayList<Book>) user.getBooks());
	uiModel.addAttribute("books", books);
	uiModel.addAttribute("user", user);
	Collection<Book> archive = (Collection<Book>) bookArhive.getArhive();

	uiModel.addAttribute("bookArhive", archive);
	return "users/user_detail";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") Integer id, Model uiModel) {
	User user = storage.getUser(id);
	bookArhive.addBooks(user.getBooks());
	storage.removeUser(id);
	return listUsers(uiModel);
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(User user, BindingResult bindingResult, Model uiModel,
	    HttpServletRequest httpServletRequest,
	    RedirectAttributes redirectAtributes, Locale locale) {

	if (bindingResult.hasFieldErrors()) {
	    System.out.println(bindingResult.getAllErrors());
	    return listUsers(uiModel);
	}
	BookList books = new BookList();
	uiModel.asMap().clear();
	User userForUpdate = null;

	userForUpdate = storage.getUser(user.getId());
	ArrayList<String> errorList = validator.validate(user);
	if (errorList.size() > 0) {
	    books.setBookList((ArrayList<Book>) userForUpdate.getBooks());
	    uiModel.addAttribute("books", books);
	    uiModel.addAttribute("user", user);
	    uiModel.addAttribute("errors", errorList);
	    ArrayList<Book> archive = new ArrayList<Book>();

	    archive.addAll(bookArhive.getArhive());
	    uiModel.addAttribute("bookArhive", archive);
	    return "users/user_detail";

	}
	user.setBooks(userForUpdate.getBooks());
	user = bookArhiveUpdate(user);
	userForUpdate.setBooks(user.getBooks());
	userForUpdate.setActive(user.isActive());
	userForUpdate.setAge(user.getAge());
	userForUpdate.setName(user.getName());

	storage.addUser(userForUpdate);

	return listUsers(uiModel);
    }

    private User bookArhiveUpdate(User user) {
	ArrayList<Integer> idsBooksForGet = user.getIdsBooksForGet();
	ArrayList<Integer> idsBooksForRej = user.getIdsBooksForRej();
	BookList usersBooks = new BookList();
	usersBooks.setBookList(user.getBooks());

	if (idsBooksForGet != null) {
	    for (Integer id : idsBooksForGet) {
		System.out.println(id);
		System.out.println("Book Archive: " + bookArhive);
		usersBooks.addBook(bookArhive.getBook(id));
	    }
	}
	if (idsBooksForRej != null) {
	    for (Integer id : idsBooksForRej) {

		bookArhive.addBook(usersBooks.extractBook(id));
	    }
	}
	user.setBooks(usersBooks.getBookList());
	return user;

    }

}
