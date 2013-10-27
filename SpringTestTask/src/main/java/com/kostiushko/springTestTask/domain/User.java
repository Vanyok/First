package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @Size(min = 1)
    private String name;
    private boolean active;
    private Integer id;
    private ArrayList<Book> books;
    private ArrayList<Integer> idsBooksForGet;
    private ArrayList<Integer> idsBooksForRej;
    @NotNull
    @DecimalMin(value = "1")
    private Integer age;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public ArrayList<Book> getBooks() {
	return books;
    }

    public void setBooks(ArrayList<Book> books) {
	this.books = books;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((age == null) ? 0 : age.hashCode());
	result = prime * result + ((books == null) ? 0 : books.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
		+ ((idsBooksForGet == null) ? 0 : idsBooksForGet.hashCode());
	result = prime * result
		+ ((idsBooksForRej == null) ? 0 : idsBooksForRej.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	User other = (User) obj;
	if (active != other.active)
	    return false;
	if (age == null) {
	    if (other.age != null)
		return false;
	} else if (!age.equals(other.age))
	    return false;
	if (books == null) {
	    if (other.books != null)
		return false;
	} else if (!books.equals(other.books))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (idsBooksForGet == null) {
	    if (other.idsBooksForGet != null)
		return false;
	} else if (!idsBooksForGet.equals(other.idsBooksForGet))
	    return false;
	if (idsBooksForRej == null) {
	    if (other.idsBooksForRej != null)
		return false;
	} else if (!idsBooksForRej.equals(other.idsBooksForRej))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "User [name=" + name + ", active=" + active + ", id=" + id
		+ ", books=" + books + ", idsBooksForGet=" + idsBooksForGet
		+ ", idsBooksForRej=" + idsBooksForRej + ", age=" + age + "]";
    }

    public ArrayList<Integer> getIdsBooksForGet() {
	return idsBooksForGet;
    }

    public void setIdsBooksForGet(ArrayList<Integer> idsBooksForGet) {
	this.idsBooksForGet = idsBooksForGet;
    }

    public ArrayList<Integer> getIdsBooksForRej() {
	return idsBooksForRej;
    }

    public void setIdsBooksForRej(ArrayList<Integer> idsBooksForRej) {
	this.idsBooksForRej = idsBooksForRej;
    }

}
