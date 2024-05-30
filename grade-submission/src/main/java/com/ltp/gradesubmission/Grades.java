package com.ltp.gradesubmission;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;


public class Grades {
   @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @Score(message = "Score must be a letter grade")
    private String score;
    private String id;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grades(){
        this.id = UUID.randomUUID().toString();
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

    @Override
    public String toString() {
        return "Grades{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
