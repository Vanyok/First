package com.kostiushko.springTestTask.domain;

import javax.validation.constraints.NotNull;

public class Book {

    private Integer id;
    @NotNull
    private String tittle;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTittle() {
	return tittle;
    }

    public void setTittle(String tittle) {
	this.tittle = tittle;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
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
	Book other = (Book) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (tittle == null) {
	    if (other.tittle != null)
		return false;
	} else if (!tittle.equals(other.tittle))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Book [id=" + id + ", tittle=" + tittle + "]";
    }

}
