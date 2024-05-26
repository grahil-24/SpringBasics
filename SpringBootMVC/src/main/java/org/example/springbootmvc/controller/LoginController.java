package org.example.springbootmvc.controller;

import org.example.springbootmvc.service.LoggedUserManagementService;
import org.example.springbootmvc.service.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model page){
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model page){
        boolean flag = true;
        LoginProcessor lp = new LoginProcessor(new LoggedUserManagementService());
        if(lp.login()){
            page.addAttribute("message", "success");
        }else{
            page.addAttribute("message", "fail");
        }
        return "login.html";
    }
}
