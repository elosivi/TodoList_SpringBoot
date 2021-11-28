package com.example.demo.controller;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.imp.TaskServiceImp;
import com.example.demo.service.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	
	@GetMapping ("/MyTodoList")
	public String AllTasks(Model model) {
		model.addAttribute("allTasks", taskService.getAll());
		model.addAttribute("newTask", new Task());
		
		return "TodoPage";
	}
	
	@PostMapping ("/MyTodoList")
	public Task AddTask (@RequestBody Task task){
		task.setCreatedDate(new Date());
		return taskService.addTask(task);
	}
	
	@GetMapping ("/{id}")
	public Task getOne(@PathVariable Long id) {
		
		return taskService.getTask(id);
	}
	
	@PutMapping ("/{id}")
	public Task EditTask (@RequestBody Task task, @PathVariable Long id){
		return taskService.updateTask(task, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(Long id) {
		taskService.deleteTask(id);
	}
	
	
}
