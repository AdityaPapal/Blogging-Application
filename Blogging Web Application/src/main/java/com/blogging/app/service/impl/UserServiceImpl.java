package com.blogging.app.service.impl;

import com.blogging.app.entities.User;
import com.blogging.app.exception.ResourceNotFoundException;
import com.blogging.app.payloads.UserDto;
import com.blogging.app.repositories.UserRepo;
import com.blogging.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userdto) {
        User user = this.dtoToUser(userdto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userdto, int userId) {

        User user =    this.userRepo.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","id",userId));

        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPass(userdto.getPass());
        user.setAbout(userdto.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDto userdto1 = this.userToDto(updatedUser);
        return userdto1;

        }

    @Override
    public UserDto getUserById(int id) {
        User user = this.userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("user","Id",id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>  users =  this.userRepo.findAll();

        List<UserDto> userDtos  = users.stream().map(
                user->this.userToDto(user)).collect(Collectors.toList());

        return  userDtos;
    }

    @Override
    public void deleteUser(int id) {
            User user = this.userRepo.findById(id).orElseThrow(
                    ()-> new ResourceNotFoundException("user","id",id));

            this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userdto){
        User user = new User();
        user.setId(userdto.getId());
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPass(userdto.getPass());
        user.setAbout(userdto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(user.getId());
        userdto.setName(user.getName());
        userdto.setEmail(user.getEmail());
        userdto.setPass(user.getPass());
        userdto.setAbout(user.getAbout());
        return userdto;
    }





}
