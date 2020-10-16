package com.reactandspring.backenduser.services;

import java.util.ArrayList;
import java.util.List;

import com.reactandspring.backenduser.dtos.UserDTO;
import com.reactandspring.backenduser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> listDTO = new ArrayList<>();

        repository.findAll()
                .forEach(element -> listDTO.add(new UserDTO(element)));

        return listDTO;
    }
}
