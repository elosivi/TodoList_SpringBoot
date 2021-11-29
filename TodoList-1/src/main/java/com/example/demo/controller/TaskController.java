package com.example.demo.controller;

import java.util.Date;

import javax.validation.Valid;

import com.example.demo.model.Task;
import com.example.demo.service.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@PostMapping (value="/saveTask")
	public String addTask ( @Valid @ModelAttribute("task") Task task, BindingResult result, Model model){
		if (result.hasErrors()) {
           return "TodoPage"; // add a message for the user
        }
		
		taskService.saveTask(task);
		 //model.addAttribute("task", taskService.findAll());
	     //model.addAttribute("task", new Task());
	    
		
        return "TodoPage";
	}
	
	
	@GetMapping ("/MyTodoList")
	public String AllTasks(Model model) {
		model.addAttribute("allTasks", taskService.findAll());
		//model.addAttribute("newTask", model)
		return "TodoPage";
	}
	
	
	@GetMapping ("/{id}")
	public Task getOne(@PathVariable Long id) {
		
		return taskService.findTaskById(id);
	}
	
	@PutMapping ("/{id}")
	public Task EditTask (@RequestBody Task task, @PathVariable Long id){
		return taskService.updateTask(task);
	}
	
	@DeleteMapping("/{id}")
	public void delete(Long id) {
		taskService.deleteTask(id);
	}
	
	
}
