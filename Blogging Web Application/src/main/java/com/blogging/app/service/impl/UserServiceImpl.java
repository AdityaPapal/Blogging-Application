package com.blogging.app.service.impl;

import com.blogging.app.payloads.UserDto;
import com.blogging.app.repositories.UserRepo;
import com.blogging.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto user) {



        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, int userId) {



        return null;
    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return List.of();
    }

    @Override
    public void deleteUser(int id) {

    }
}
