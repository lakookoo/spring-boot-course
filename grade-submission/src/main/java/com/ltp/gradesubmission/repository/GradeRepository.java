package com.ltp.gradesubmission.repository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.gradesubmission.Grades;


public class GradeRepository{
   private List<Grades> studentGrades = new ArrayList<>();

   public Grades getGrade(int index){
    return studentGrades.get(index);
   }

   public void addGrade(Grades grade){
    studentGrades.add(grade);
   }

   public void updateGrade(Grades grade, int index){
     studentGrades.set(index, grade);
   }

   public List<Grades> getGrades(){
    return studentGrades;
   }
}