package com.example.userService.service

import com.example.userService.dto.UserDto
import com.example.userService.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl(
    private val usersRepository: UsersRepository
) : UsersService {
    override fun getByLogin(login: String) {
        usersRepository.getByLogin(login)
    }

    override fun create(user: UserDto) {
        usersRepository.create(user.login, user.password, user.email)
    }
}