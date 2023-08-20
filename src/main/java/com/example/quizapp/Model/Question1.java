package com.example.quizapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question1 {
    @Id
    private int pid;
    private String question;
    private String right_answer;
    private String difficulty;

    public Question1(int pid, String question, String right_answer, String difficulty) {
        this.pid = pid;
        this.question = question;
        this.right_answer = right_answer;
        this.difficulty = difficulty;
    }

    public Question1() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pid;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        result = prime * result + ((right_answer == null) ? 0 : right_answer.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Question [pid=" + pid + ", question=" + question + ", right_answer=" + right_answer + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question1 other = (Question1) obj;
        if (pid != other.pid)
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        if (right_answer == null) {
            if (other.right_answer != null)
                return false;
        } else if (!right_answer.equals(other.right_answer))
            return false;
        return true;
    }
}
