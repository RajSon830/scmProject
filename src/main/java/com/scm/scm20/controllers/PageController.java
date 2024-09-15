package com.scm.scm20.controllers;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.helper.Message;
import com.scm.scm20.helper.MessageType;
import com.scm.scm20.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model){

        UserForm userForm= new UserForm();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    @PostMapping(value ="/do-register")
    public String processRegister(@ModelAttribute  UserForm userForm, HttpSession session){

        // validate the form
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(userForm.getAbout());
        user.setProfilePic(userForm.getPhoneNumber());
        user.setProfilePic("https://imgs.search.brave.com/oL_zb65hhbdmGSqcefHYCnagcZxc06NwROTyCJV2HXg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzA3LzI1LzQyLzk2/LzM2MF9GXzcyNTQy/OTY4OF96NGtvMkRO/V3VvN0lVTVhybTBF/UVRUeDRYNVBVTndE/Ui5qcGc");

        // user service
        userService.saveUser(user);

        Message  message=Message.builder().content("Registration Successful").type(MessageType.green).build();
        // add message
        session.setAttribute("message",message);

        return "redirect:/register";
    }




}
