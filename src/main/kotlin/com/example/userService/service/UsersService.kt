package com.example.userService.service

import com.example.userService.dto.UserDto

interface UsersService {
    fun getByLogin(login: String): UserDto
    fun create(user: UserDto): Int
}