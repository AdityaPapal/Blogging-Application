package com.blogging.app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    // For Data Transfer

    private int id;
    private String name;
    private String email;
    private String pass;
    private String about;

}
