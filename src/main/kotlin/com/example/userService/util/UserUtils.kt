package com.example.userService.util

import com.example.userService.dto.UserDto
import com.example.userService.model.User

fun User.toDto() = UserDto(
    this.id,
    this.login,
    this.password,
    this.email
)