package com.example.quizapp.Model;

public class Response 
{
    private int pid;
    private String right_answer;
    public Response() {
    }
    public Response(int id, String right_answer) {
        this.pid = id;
        this.right_answer = right_answer;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int id) {
        this.pid = id;
    }
    public String getRight_answer() {
        return right_answer;
    }
    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pid;
        result = prime * result + ((right_answer == null) ? 0 : right_answer.hashCode());
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
        Response other = (Response) obj;
        if (pid != other.pid)
            return false;
        if (right_answer == null) {
            if (other.right_answer != null)
                return false;
        } else if (!right_answer.equals(other.right_answer))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Response [id=" + pid + ", right_answer=" + right_answer + "]";
    }
      
    
    
}
