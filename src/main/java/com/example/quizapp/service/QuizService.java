package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.Dao.QuestionDao;
import com.example.quizapp.Dao.QuizDao;
import com.example.quizapp.Model.Question1;
import com.example.quizapp.Model.QuestionWarpper;
import com.example.quizapp.Model.Quiz;
import com.example.quizapp.Model.Response;

@Service
public class QuizService 
{
    @Autowired
    QuizDao quizDao;
    
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String dificulty, int num, String title) 
    {
        Quiz quiz = new Quiz();
        
        quiz.setTitle(title);
        List<Question1> questions = questionDao.getQuestionByDifficulty(dificulty,num);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public Quiz getQuiz(int id) {
        return quizDao.findById(id).get();
    }

    public List<QuestionWarpper> getQuestions(int id) 
    {
        Quiz quiz = quizDao.findById(id).get();

        List<Question1> questions1s = quiz.getQuestions();
        List<QuestionWarpper> questionWarppers = new ArrayList<>();

        for(Question1 question: questions1s)
        {
            QuestionWarpper qw = new QuestionWarpper(question.getPid(),question.getQuestion());
            questionWarppers.add(qw);
        }

        return questionWarppers;
    }

    public Integer getScore(int id, List<Response> responses) 
    {
        Quiz quiz = quizDao.findById(id).get();

        List<Question1> questions = quiz.getQuestions();

        int score = 0;

        for(Question1 question:questions)
        {
            for(Response response:responses)
            {
                if(question.getPid()==response.getPid())
                {
                    if(question.getRight_answer().equals(response.getRight_answer()))
                        ++score;
                }
            }
        }
        return score;
    }
    
}
