package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Model.QuestionWarpper;
import com.example.quizapp.Model.Response;
import com.example.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController 
{

    @Autowired
    QuizService quizService;
    
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String difficulty, @RequestParam int num, @RequestParam String title)
    {
        quizService.createQuiz(difficulty,num,title);
        return new ResponseEntity<String>("success",HttpStatus.CREATED);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWarpper>> getQuiz(@PathVariable("id") int id)
    {
        return new ResponseEntity<List<QuestionWarpper>>(quizService.getQuestions(id), HttpStatus.OK);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses)
    {
        return new ResponseEntity<Integer>(quizService.getScore(id, responses), HttpStatus.OK);
    }
}
