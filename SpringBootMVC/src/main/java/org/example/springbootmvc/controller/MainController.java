package org.example.springbootmvc.controller;

import org.example.springbootmvc.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//this is a stereotype annotation and spring creates a bean of this type
@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    //@RequestParam is used to fetch query strings from URLs
    @RequestMapping("/home")
    public String home(@RequestParam(required = false, defaultValue = "blue") String color, @RequestParam(required = false, defaultValue = "rahil") String name,  Model page) {
        //add the data we want the controller to send to the view
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }

    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color, Model page){
        page.addAttribute("color", color);
        page.addAttribute("name", "rahil");
        return "home.html";
    }

    @GetMapping("/main")
    public String home(){
        String username = this.loggedUserManagementService.getUsername();
        if(username == null){
            //to redirect user if user has not logged in
            return "redirect:/login";
        }
        return "main.html";
    }
}
