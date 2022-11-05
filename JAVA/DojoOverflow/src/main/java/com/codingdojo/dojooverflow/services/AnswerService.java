package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService (AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> allAnswers(){
		return answerRepository.findAll();
	}
	
	public List<Answer> questionAnswers(Long questionId) {
		return answerRepository.findByQuestionIdIs(questionId);
	}
	
	public Answer addAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		}else {
			return null;
		}
	}
}
