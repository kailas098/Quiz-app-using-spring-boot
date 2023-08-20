package com.example.quizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
    
}
