package com.example.userService.service

import com.example.userService.dto.UserDto
import com.example.userService.repository.UsersRepository
import com.example.userService.util.toDto
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl(
    private val usersRepository: UsersRepository
) : UsersService {
    override fun getByLogin(login: String): UserDto =
        usersRepository
            .getByLogin(login)
            ?.toDto() ?: throw RuntimeException()


    override fun create(user: UserDto): Int = usersRepository.create(user.login, user.password, user.email)

}