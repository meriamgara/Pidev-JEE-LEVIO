package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidevLevio.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
