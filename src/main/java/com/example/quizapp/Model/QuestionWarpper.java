package com.example.quizapp.Model;

public class QuestionWarpper 
{
    private int pid;
    private String question;
    
    public QuestionWarpper() {
    }
    public QuestionWarpper(int pid, String question) {
        this.pid = pid;
        this.question = question;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pid;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QuestionWarpper other = (QuestionWarpper) obj;
        if (pid != other.pid)
            return false;
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "QuestionWarpper [pid=" + pid + ", question=" + question + "]";
    }

    
}
