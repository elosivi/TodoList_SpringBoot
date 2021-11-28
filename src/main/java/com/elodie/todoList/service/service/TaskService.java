package com.example.demo.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;


public interface TaskService {

		public Task addTask(Task task);
		public Task getTask(long id);
		public List<Task> getAll();
		public Task updateTask(Task task, Long Id);
		public void deleteTask(Long id);
		
		
}
