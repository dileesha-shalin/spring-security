package spring.example.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountController {

    @GetMapping("/get-account")
    //@Secured("ROLE_ADMIN")  -- this is called method level security then no need to restrict in ProjectSecurityConfig
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")  --> THIS IS ALSO A POSSIBLE WAY TO RESTRICT USER
    //@PostAuthorize("hasAuthority('ROLE_ADMIN')") -->description in the book
    public String getAccountDetails(){

        return "here are the account details";
    }
}
