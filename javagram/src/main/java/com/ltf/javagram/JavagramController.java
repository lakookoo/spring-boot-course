package com.ltf.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;



@Controller
public class JavagramController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult() {

        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (user.getLastName().equals(user.getFirstName())){
            result.rejectValue("lastName", "", "please enter valid data");
        }
        if (result.hasErrors()) return "sign-up";
        

        return "redirect:/result";
    }
    


}
