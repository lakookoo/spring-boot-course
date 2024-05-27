package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class GradeController {

    List<Grades> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model){
        studentGrades.add(new Grades( "Harry", "Potions", "C-"));
        studentGrades.add(new Grades( "Hermione", "Arithmancy", "A+"));
        studentGrades.add(new Grades( "Neville", "Charms", "-C"));
        
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}
