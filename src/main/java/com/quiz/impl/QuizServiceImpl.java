package com.quiz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	QuizRepository quizrepo;
	@Autowired
	QuestionClient questionclient;

	@Override
	public Quiz addquiz(Quiz quiz) {
		
		return quizrepo.save(quiz);
	}

	@Override
	public List<Quiz> getallquiz() {
		
		List<Quiz> quizes= quizrepo.findAll();
		List<Quiz> newQuiz= quizes.stream().map(quiz-> {
			quiz.setQuestions(questionclient.getQuizQuestions(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuiz;
	}

	@Override
	public Quiz getquiz(Long id) {
		 Quiz quiz= quizrepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found"));
		 quiz.setQuestions(questionclient.getQuizQuestions(id));
		 return quiz;
	}

	@Override
	public void deletequiz(long id) {
		quizrepo.deleteById(id);
		
	}
	

}
