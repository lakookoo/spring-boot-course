package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

    private List<Item> items = new ArrayList<Item>();
    
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getItemIndex(id);
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("item", index == -1000 ? new Item() : items.get(index));
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item) {
        items.add(item);
        return "redirect:/inventory";

    }

    public Integer getItemIndex(String id){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId().equals(id)) return i;

        }
        return -1000;
    }




}
