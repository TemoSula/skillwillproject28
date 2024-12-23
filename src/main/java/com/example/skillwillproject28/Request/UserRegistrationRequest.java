package com.example.skillwillproject28.Request;

import com.example.skillwillproject28.Enums.Roles;

import javax.management.relation.Role;

public record UserRegistrationRequest(String username, String password, Roles roles) {

}
