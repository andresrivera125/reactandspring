package com.reactandspring.backenduser.services;

import java.util.List;

import com.reactandspring.backenduser.dtos.UserDTO;

public interface IUserService {
    List<UserDTO> findAll();
}
