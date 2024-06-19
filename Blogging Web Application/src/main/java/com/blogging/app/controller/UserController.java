package com.blogging.app.controller;

import com.blogging.app.payloads.ApiResponse;
import com.blogging.app.payloads.UserDto;
import com.blogging.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

        @Autowired
        private UserService userService;

        // post  -- create user
        @PostMapping("/")
        public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto){
                UserDto createdUserDto = this.userService.createUser(userdto);
                return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
        }

        // put   -- update user
        @PutMapping("/{userId}") // path url variable
        public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userdto , @PathVariable("userId") int uid){
                UserDto updatedUser = this.userService.updateUser(userdto,uid);
                return ResponseEntity.ok(updatedUser);
        }

       // Delete  -- delete user
        @DeleteMapping("/{userId}")
        public  ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int id){
                this.userService.deleteUser(id);
//                return ResponseEntity.ok(Map.of("message","user deleted Successfully"));
                return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
        }

       // Get     -- All        User get
        @GetMapping("/")
        public  ResponseEntity<List<UserDto>> getAllUser(){
               return ResponseEntity.ok(this.userService.getAllUser());
        }

        // Get     -- User get
        @GetMapping("/{userId}")
        public  ResponseEntity<UserDto> getAllUser(@PathVariable("userId") int id){
                return ResponseEntity.ok(this.userService.getUserById(id));
        }
}
