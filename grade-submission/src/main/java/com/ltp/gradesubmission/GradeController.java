package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class GradeController {

    List<Grades> studentGrades = Arrays.asList(
        new Grades( "Harry", "Potions", "C-"),
        new Grades( "Hermione", "Arithmancy", "A+"),
        new Grades( "Neville", "Charms", "A-")
    );

    @GetMapping("/grades")
    public String getGrades(Model model){
        
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}
