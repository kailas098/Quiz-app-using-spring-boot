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
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.Model.Question1;
import com.example.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController 
{
    @Autowired
    QuestionService questionService;

    @GetMapping("questions")
    public ResponseEntity<List<Question1>> getQuestions() 
    {
        return new ResponseEntity<List<Question1>>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<Question1>> getQuestionByDifficulty(@PathVariable("difficulty") String difficulty) 
    {
        return new ResponseEntity<>(questionService.getQuestionByDifficulty(difficulty), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question1 question) 
    {
        questionService.addQuestion(question);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }
}
