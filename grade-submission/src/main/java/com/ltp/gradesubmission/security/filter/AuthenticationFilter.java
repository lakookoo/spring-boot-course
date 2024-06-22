package com.ltp.gradesubmission.security.filter;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.security.manager.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;




@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private CustomAuthenticationManager customAuthenticationManager;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
            try {
                User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
                Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
                return customAuthenticationManager.authenticate(authentication);
            } catch(IOException e){
                throw new RuntimeException();
            }
            
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        // TODO Auto-generated method stub
        super.successfulAuthentication(request, response, chain, authResult);
    }


}
