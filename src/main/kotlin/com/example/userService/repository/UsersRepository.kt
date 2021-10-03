package com.example.userService.repository

import com.example.userService.model.User


interface UsersRepository {
    fun getByLogin(login: String): User?
    fun create(login: String, password: String, email: String): Int
}