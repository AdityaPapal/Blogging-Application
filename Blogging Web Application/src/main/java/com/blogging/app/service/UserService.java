package com.blogging.app.service;

import com.blogging.app.entities.User;
import com.blogging.app.payloads.UserDto;

import java.util.List;

public interface UserService {

        UserDto createUser(UserDto user);
        UserDto updateUser(UserDto user,int userId);
        UserDto getUserById(int id );
        List<UserDto> getAllUser();
        void deleteUser(int id);

}
