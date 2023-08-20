package com.example.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.Dao.QuestionDao;
import com.example.quizapp.Model.Question1;

@Service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao;

    public List<Question1> getAllQuestions() 
    {
        return questionDao.findAll();
    }
    
    public List<Question1> getQuestionByDifficulty(String difficulty)
    {
        return questionDao.findByDifficulty(difficulty);
    }

    public String addQuestion(Question1 question) 
    {
        return questionDao.save(question).toString();
    }
}
