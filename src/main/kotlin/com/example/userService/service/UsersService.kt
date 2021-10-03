package com.example.userService.service

import com.example.userService.dto.UserDto

interface UsersService {
    fun getByLogin(login : String)
    fun create(user : UserDto)
}