package com.lts.shows_workbook;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ShowsController {

    @GetMapping("/")
    public ModelAndView getShows(){
        Map<String, Shows> model = new HashMap<String, Shows>();
        model.put("first", new Shows("Breaking Bad", "Ozymandias", 10.0));
        model.put("second", new Shows("Attack on Titan", "Hero", 9.9));
        model.put("third", new Shows("Attack on Titan", "Perfect Game", 9.9));
        model.put("fourth", new Shows("Star Wars: The Clone Wars", "Victory and Death", 	9.9));
        model.put("fifth", new Shows("Mr. Robot", "407 Proxy Authentication Required", 9.9));

        return new ModelAndView("shows", model);
    }
}
