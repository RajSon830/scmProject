package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {


    @RequestMapping("/home")
    public String home(Model model)  {

        model.addAttribute("name","Welcome  world");
        model.addAttribute("love","zahra");
        model.addAttribute("youttubeChannel","Sajal Nasir");
        return "home";
    }


    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        return "services";
    }


    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    @GetMapping("/login")
    public String login(){
        return new String("login");
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }





}
