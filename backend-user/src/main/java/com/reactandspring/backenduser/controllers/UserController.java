package com.reactandspring.backenduser.controllers;

import java.util.List;

import com.reactandspring.backenduser.dtos.UserDTO;
import com.reactandspring.backenduser.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/users")
@CrossOrigin
@EnableWebMvc
public class UserController {

    IUserService service;

    @Autowired
    public void setService(IUserService service){
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll(){
        return service.findAll();
    }
}
