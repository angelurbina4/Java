package com.codingdojo.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=100)
	private String title;
	
	@Size(min=5, max=200)
	private String description;
	
	@Size(min=3, max= 0)
	private String language;
	
	@Min(100)
	private Integer numberOfPages;
	
	//Esto no permitirá que la columna createdAt se actualice después de la creación 
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	
	public Book() {
		
	}
	
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public Integer getNumberOfPages() {
		return numberOfPages;
	}




	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}




	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
	
	

}
