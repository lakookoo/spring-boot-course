package com.lts.shows_workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class ShowsController {

    @GetMapping("/")
    public String getShows(Model model){
        model.addAttribute("show1", new Shows("Breaking Bad", "Ozymandias", 10.0));
        model.addAttribute("show2", new Shows("Attack on Titan", "Hero", 9.9));
        model.addAttribute("show3", new Shows("Attack on Titan", "Perfect Game", 9.9));
        model.addAttribute("show4", new Shows("Star Wars: The Clone Wars", "Victory and Death", 9.9));
        model.addAttribute("show5", new Shows("Mr. Robot", "407 Proxy Authentication Required", 9.9));
        return "shows";
    }
}
