package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> AllQuestions() {
        return questionRepository.findAll();
    }
    public List<Question> getAssignedTags(Tag tag){
    	return questionRepository.findAllByTags(tag);
    }
    
    public List<Question> getUnassignedTags(Tag tag){
    	return questionRepository.findByTagsNotContains(tag);
    }

    // retrieves a question
    public Question findById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public Question addQuestion(Question question) {
    	return questionRepository.save(question);
    }
    
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }
    
    // to delete a question, we simply pass in the question ID and if our repository finds it, the question will be deleted
    public void deleteProduct(Question question) {
    	questionRepository.delete(question);
    }
    
    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

}