package com.codingdojo.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Title is required!  ") 
    @Size(min=3, max=30, message="Project title must be between 3 and 30 characters.  ")
    private String title;
    
    @NotEmpty(message="Project description is required!  ") 
    private String description;

    @Future(message="Due date cannot be in the past.")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message="cannot be empty")
    private Date dueDate;
    
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    private Date updatedAt;
    
 
    //Project that the logged in user is a part of
    @ManyToOne(fetch = FetchType.LAZY)
    //Before it was 'project_id' but it created a project_id column in the project table...isntead of a user_id...
    //@JoinColumn(name="project_id")
    @JoinColumn(name="user_id")
    
    private User lead;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "users_projects",
    	joinColumns = @JoinColumn(name = "project_id"),
    	inverseJoinColumns = @JoinColumn(name = "user_id")
		)
    
    private List<User> users;
    
    public Project() {}
    
    public Project(String title, String description, Date dueDate, User lead) {
    	this.title = title;
    	this.description = description;
    	this.dueDate = dueDate;
    	this.lead = lead;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getLead() {
		return lead;
	}

	public void setLead(User lead) {
		this.lead = lead;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}




//	public User getTeam() {
//		return team;
//	}
//	
//	public void setTeam(User team) {
//		this.team = team;
//	}

    
}
   