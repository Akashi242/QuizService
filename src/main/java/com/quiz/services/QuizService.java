package com.quiz.services;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizService {
	Quiz addquiz(Quiz quiz);
	List<Quiz> getallquiz();
	Quiz getquiz(Long id);
	void deletequiz(long id);

}
