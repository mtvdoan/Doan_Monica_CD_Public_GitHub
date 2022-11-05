package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public List<Tag> AllTags() {
		return tagRepository.findAll();
	}
	
	public List<Tag> getAssignedQuestions(Question question){
		return tagRepository.findAllByQuestions(question);
	}

	public List<Tag> getUnassignedQuestions(Question question){
		return tagRepository.findByQuestionsNotContains(question);
	}
	
	public Tag findById(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		}else {
			return null;
		}
	}
	
	public Tag addTag(Tag tag) {
		return tagRepository.save(tag);
	}
	// updateTag will take in a Tag object and save it to our database.
	// Our repository will automatically update an existing Tag object if their
	// IDs match
	public Tag updateTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Tag findBySubject(String subject) {
		return tagRepository.findBySubjectIs(subject);
	}
	
	public void deleteTag(Tag tag) {
		tagRepository.delete(tag);
	}
	
}

