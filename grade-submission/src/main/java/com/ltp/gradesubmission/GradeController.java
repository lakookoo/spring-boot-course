package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class GradeController {

    List<Grades> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name) {
        //Grades grade;
        // if(getGradeImdex(name) == -1000){
        //     grade = new Grades();
        // } else {
        //     grade = studentGrades.get(getGradeImdex(name));
        // }
        model.addAttribute("grade", getGradeIndex(name) == -1000 ? new Grades() : studentGrades.get(getGradeIndex(name)));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grades grade) {
        
        studentGrades.add(grade);
        return "redirect:/grades";
    }
    
    

    @GetMapping("/grades")
    public String getGrades(Model model){
        
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String name){
        for(int i = 0; i < studentGrades.size(); i++){
            if (studentGrades.get(i).getName().equals(name)) return i;
        }
        return -1000;
    }
}
