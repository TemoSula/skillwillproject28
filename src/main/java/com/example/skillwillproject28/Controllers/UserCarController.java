package com.example.skillwillproject28.Controllers;

import com.example.skillwillproject28.Models.UserCarModel;
import com.example.skillwillproject28.Response.UserCarCartsResponse;
import com.example.skillwillproject28.Services.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class UserCarController {

    @Autowired
    UserCarService ucservice;

@PreAuthorize("hasRole('ROLE_USER')")
@PostMapping("/add-In-Cart")
public UserCarCartsResponse addCarInCart(String id)
{
    return ucservice.addCarInCart(id);
}


@PreAuthorize("hasRole('ROLE_USER')")
@GetMapping("/My-Cart")
public List<UserCarCartsResponse> showMyCart()
{
    return ucservice.showMyCart();
}

}
