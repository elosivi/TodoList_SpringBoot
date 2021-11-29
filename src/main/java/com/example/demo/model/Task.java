package com.example.demo.model;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tasks")

public class Task {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column (name="id")
		private long id;
		
		@NotEmpty(message = "title may not be empty")
		@NotBlank(message = "title is mandatory")
		@Column (name="title")
		private String title;
		
		@Column (name="date")
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		public LocalDateTime createdDate;
		
		@Column (name="content")
		private String content;
		
		@Column (name="done")
		//not null
		private Boolean done = false;
		
		@Autowired
		public Task() {
			this.createdDate = LocalDateTime.now();
		}
		
		public Task(String title) {
			this.createdDate = LocalDateTime.now();
			this.title = title;
		
		}
		
		public Task(String title, String content) {
			this.createdDate = LocalDateTime.now();
			this.title = title;
			this.content = content;
			
		}

		public long getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date date) {
			this.createdDate = LocalDateTime.now();
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}


		public Boolean getDone() {
			return done;
		}

		public void setDone(Boolean done) {
			this.done = done;
		}

}
