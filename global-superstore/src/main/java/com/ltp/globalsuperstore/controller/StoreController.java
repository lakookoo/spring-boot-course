package com.ltp.globalsuperstore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.service.ItemService;

import jakarta.validation.Valid;

@Controller
public class StoreController {

    ItemService itemService = new ItemService();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", itemService.getItemById(id));
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid @ModelAttribute("item") Item item, BindingResult result, RedirectAttributes redirectAttributes ) {
        if (item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Price cannot be less tham the discount");
        }
        if(result.hasErrors()) return "form";
        String status = itemService.handleSubmit(item);
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";

    }

    

    

}
