package com.example.quizapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.quizapp.Model.Question1;


public interface QuestionDao extends JpaRepository<Question1, Integer> 
{
    public List<Question1> findByDifficulty(String difficulty);

    @Query(value="SELECT * FROM Question1 q WHERE q.difficulty=:difficulty ORDER BY RANDOM() LIMIT :num",nativeQuery=true)
    public List<Question1> getQuestionByDifficulty(String difficulty, int num);
}
