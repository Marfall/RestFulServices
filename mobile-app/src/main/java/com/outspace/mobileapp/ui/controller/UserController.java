package com.outspace.mobileapp.ui.controller;

import com.outspace.mobileapp.dto.UserDto;
import com.outspace.mobileapp.service.UserService;
import com.outspace.mobileapp.ui.model.request.UserDetailsRequestModel;
import com.outspace.mobileapp.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {

        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();                   //создание дто
        BeanUtils.copyProperties(userDetails, userDto);   // копирование полей с одинаковыми именами из запроса в дто

        UserDto createdUser = userService.createUser(userDto); // создание пользователя для базы на основе дто
        BeanUtils.copyProperties(createdUser, returnValue);    // копирование db-user в возвращаемый userRest с publicId (id в базе долже быть скрыт)

        return returnValue;
    }

    @PutMapping
    public String updateUser() {

        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser()
    {
        return "delete user was called";
    }
}
