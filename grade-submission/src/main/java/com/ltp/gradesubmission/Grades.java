package com.ltp.gradesubmission;

public class Grades {
    private String name;
    private String subject;
    private String score;

    public Grades(String name, String subject, String score){
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grades(){
        
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getScore(){
        return score;
    }

    public void setScore(String score){
        this.score = score;
    }
}
