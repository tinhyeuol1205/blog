package com.binh.blog.controller;

import com.binh.blog.model.Role;
import com.binh.blog.model.User;
import com.binh.blog.model.UserRegistration;
import com.binh.blog.service.UserService;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("userRegistion", new UserRegistration());
        String msg = "";
        model.addAttribute("msg", msg);
        return "register";
    }
    @PostMapping("/register")
    public String addUser(UserRegistration userRegistion,Model model) {
        System.out.println("username: "+userRegistion.getUserName());
        System.out.println("pw: "+userRegistion.getPassword());
        System.out.println("pw1: "+userRegistion.getConfirmPassword());
        String msg="";
        if (!userRegistion.getPassword().equals(userRegistion.getConfirmPassword())) {
        	msg= "The two password don't match!";
            model.addAttribute("msg", msg);
            model.addAttribute("userRegistion", new UserRegistration());
            return "register";
        }
        else if(userService.getUser(userRegistion.getUserName())!= null) {
			msg= "This username already exists!";
            model.addAttribute("msg", msg);
            model.addAttribute("userRegistion", new UserRegistration());
            return "register";
		}
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        if (pattern.matcher(userRegistion.getUserName()).find()){
        	msg= "No special characters are allowed in the username!";
            model.addAttribute("msg", msg);
            model.addAttribute("userRegistion", new UserRegistration());
            return "register";
        }
        userService.save(new User(userRegistion.getUserName(),userRegistion.getPassword(),Arrays.asList(new Role("User"))));
        return "redirect:";
    } 
}
