package org.example.springbootmvc.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//request scope means a new bean is created for every new http request
//this is to ensure that, sensitive data like username password are not stored in the memory
//for too long
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {

        this.loggedUserManagementService = loggedUserManagementService;
    }
    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();
        if(username.equals("admin") && password.equals("admin")){
            this.loggedUserManagementService.setUsername(username);
            return true;
        }else{
            return false;
        }
    }
}
