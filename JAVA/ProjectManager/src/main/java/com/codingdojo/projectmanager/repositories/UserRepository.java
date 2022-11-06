package com.codingdojo.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
	List<User> findAll();
	Optional<User>findByEmail(String email);	
	Optional<User>findByPassword(String password);	
	Optional<User>findByFirstName(String firstName);
	Optional<User>findByLastName(String lastName);
	Optional<User>findById(Long id);	
	User findByIdIs(Long id);

	
	//Gives list of users that are leads of projects.
	List<User> findAllByProjects(Project project);
	
	//Gives list of users that are NOT LEADS of a project, but are a part of the team...
	List<User> findByProjectsNotContains(Project project);
 
}