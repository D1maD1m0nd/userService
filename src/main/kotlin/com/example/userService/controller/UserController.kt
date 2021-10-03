package com.example.userService.controller

import com.example.userService.dto.UserDto
import com.example.userService.service.UsersService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val usersService: UsersService
) {
    @GetMapping("/{login}")
    fun getById(@PathVariable login : String){

    }

    @PostMapping
    fun create(@RequestBody user : UserDto) {

    }
}