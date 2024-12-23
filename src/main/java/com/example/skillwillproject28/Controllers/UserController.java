package com.example.skillwillproject28.Controllers;

import com.example.skillwillproject28.Models.UserModel;
import com.example.skillwillproject28.Repositories.UserRepository;
import com.example.skillwillproject28.Request.UserRegistrationRequest;
import com.example.skillwillproject28.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableMethodSecurity(securedEnabled = true)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepo;


    @PostMapping("/registration")
    public String Registration(@RequestBody UserRegistrationRequest request)
    {
       return userService.registration(request);
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        return userService.login(username,password);
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @GetMapping("/whoamI")
    public String whoAmI()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
