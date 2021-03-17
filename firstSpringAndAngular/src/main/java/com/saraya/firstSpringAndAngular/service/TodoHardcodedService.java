package com.saraya.firstSpringAndAngular.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.firstSpringAndAngular.bean.Todo;
@Service
public class TodoHardcodedService {
	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter,"vsoumare","Learn HTML", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn CSS", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn JAVA", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn JAVASCRIPT", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn NODE", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn ANGULAR", new Date(), false));
		todos.add(new Todo(++idCounter,"vsoumare","Learn KAFKA", new Date(), false));
	}
	
	public List<Todo>findAll(){
		return todos;
	}
	public Todo deleteById(int id) {
		Todo todo = findById(id);
		if(todo==null) {
			return null;
		}else {
			todos.remove(todo);
		}
		return todo;
		
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
 }
