package com.example.demo.service.imp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.service.TaskService;

@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	

	@Override
	public Task addTask(Task task) {
		
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAll() {
		List<Task> allTasks = new ArrayList<>();
		taskRepository.findAll().forEach(allTasks::add);
		return allTasks;
	}

	@Override
	public Task updateTask(Task task, Long id) {
		
		Task taskUpdate = taskRepository.findById(id).get();
		taskUpdate.setContent(task.getContent());
		taskUpdate.setTitle(task.getTitle());
		taskUpdate.setDone(task.getDone());
		return taskRepository.saveAndFlush(taskUpdate);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

	@Override
	public Task getTask(long id) {
		return taskRepository.findById(id).get();
	}
	
	

}
