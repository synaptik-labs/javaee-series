package com.synaptik.javaee;

import com.synaptik.javaee.data.Todo;

import java.util.List;

public interface TodoEJB {
	List<Todo> findAll();
	void create(Todo incoming);
	void update(Long id, Todo incoming);
	void remove(Long id);
}
