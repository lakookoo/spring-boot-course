package com.ltp.gradesubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grades;
import com.ltp.gradesubmission.repository.GradeRepository;


public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public Grades getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grades grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grades grade, int index) {
        gradeRepository.updateGrade(grade, index);
    }

    public List<Grades> getGrades() {
        return gradeRepository.getGrades();
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grades getGradeById(String id){
        int index = getGradeIndex(id);
        return  index == Constants.NOT_FOUND ? new Grades() : getGrade(index);
    }

    public void submitGrade(Grades grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }
}
