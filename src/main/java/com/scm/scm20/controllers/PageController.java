package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String servicePage(){
        return "services";
    }


}
