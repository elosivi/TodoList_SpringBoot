package com.example.demo.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.service.TaskService;

@Transactional
@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	/*
	 * CREATE a new task 
	 * @param task
	 */
	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	/*
	 * READ all the todolist tasks
	 * @return an array of tasks
	 */
	@Override
	public List<Task> findAll() {
		List<Task> allTasks = new ArrayList<>();
		taskRepository.findAll().forEach(allTasks::add);
		return allTasks;
	}
	
	/*
	 * READ one task
	 * @param id
	 */

	@Override
	public Task findTaskById(long id) {
		//return taskRepository.findById(id).get();
		Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            return taskOptional.get();
        }
        return null;
	}

	/*
	 * UPDATE one task
	 * @param id
	 */
	@Override
	//public Task updateTask(Task task, Long id) {
		//Task taskUpdate = taskRepository.findById(id).get();
		//taskUpdate.setContent(task.getContent());
		//taskUpdate.setTitle(task.getTitle());
		//taskUpdate.setDone(task.getDone());
		//return taskRepository.saveAndFlush(taskUpdate);
	//}
	public Task updateTask(Task task) {
	
			return taskRepository.save(task);
	}

	/*
	 * DELETE a task
	 * @param id
	 */
	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}
	
	
	
	

}
