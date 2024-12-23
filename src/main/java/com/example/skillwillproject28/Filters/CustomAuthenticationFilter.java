package com.example.skillwillproject28.Filters;

import com.example.skillwillproject28.Models.UserModel;
import com.example.skillwillproject28.Repositories.UserRepository;
import com.example.skillwillproject28.Services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Security;
import java.util.List;

@Component
@Qualifier("CustomAuthFilter")
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = "";
        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request,response);
            return;
        }
        token = authHeader.substring(7);
        if(jwtService.isExpriedToken(token))
        {
            throw new RuntimeException("token is expired");
        }
        UserModel userModel = userRepo.findUserByUsername(jwtService.getAllClaims(token).get("username").toString());
       UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userModel.getUserName(),userModel.getPassword(),
                List.of(new SimpleGrantedAuthority(userModel.getRole().toString())));
        if(SecurityContextHolder.getContext().getAuthentication() == null)
        {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        /*if(SecurityContextHolder.getContext().getAuthentication() != null)
        {
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }*/

     filterChain.doFilter(request,response);

    }
}
