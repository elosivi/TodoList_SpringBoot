package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	
	//List<Task> findAll();
	
	//Task findOneById(long id);;
	
	//Task saveTask(Task task);
	
	//void deleteByIdInBatch(long id);
	
	
	

}
