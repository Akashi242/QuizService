package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizservice;
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizservice.addquiz(quiz);
	}
	
	@GetMapping
	public List<Quiz> getallquiz(){
		return quizservice.getallquiz();
	}
	
	@GetMapping("/{id}")
	public Quiz getsinglequiz(@PathVariable Long id) {
		return quizservice.getquiz(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletequiz(@PathVariable Long id) {
		quizservice.deletequiz(id);
	}

}
