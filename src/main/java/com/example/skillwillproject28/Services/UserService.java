package com.example.skillwillproject28.Services;

import com.example.skillwillproject28.Models.UserModel;
import com.example.skillwillproject28.Repositories.UserRepository;
import com.example.skillwillproject28.Request.UserRegistrationRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    JwtService jwtService;


    public String registration(UserRegistrationRequest request)
    {
        UserModel userModel = new UserModel();
        userModel.setUserName(request.username());
        userModel.setPassword(request.password());
        userModel.setRole(request.roles());
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        userRepo.save(userModel);
        return "Registration successfully";
    }




    public String login(String username, String password)
    {
        UserModel userModel1 = userRepo.findUserByUsername(username);
        if(userModel1 == null)
        {
         throw new RuntimeException("user not found");
        }
        if(!encoder.matches(password,userModel1.getPassword()))
        {
            throw new RuntimeException("username or password is not correct");
        }
        return jwtService.generateToken(userModel1);

    }



}
