package com.codingdojo.dojosninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninjas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojos_id")
    private Dojos dojos;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date createdAt;
    private Date updatedAt;
    
    public Ninjas() {
        
    }
    
    public Ninjas (Long id, String firstName, String lastName, int age, Date createdAt, Date updatedAt, Dojos dojos) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    	this.dojos = dojos;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dojos getDojos() {
		return dojos;
	}
	public void setDojos(Dojos dojos) {
		this.dojos = dojos;
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
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}

