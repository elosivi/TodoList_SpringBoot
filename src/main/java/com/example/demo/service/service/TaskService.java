package com.example.demo.service.service;

import java.util.List;

import com.example.demo.model.Task;


public interface TaskService {

		public Task saveTask(Task task);
		
		public Task findTaskById(long id);
		
		public List<Task> findAll();
		
		//public Task updateTask(Task task, Long Id);
		public Task updateTask(Task task);
		
		public void deleteTask(Long id);
		
		
}
