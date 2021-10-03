package com.example.userService.repository

import com.example.userService.model.User
import com.example.userService.util.getIntOrNull
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl(
    private val jdbcTemplate : NamedParameterJdbcTemplate
) : UsersRepository {
    override fun getByLogin(login: String) : User? =
        jdbcTemplate.query("select * from cargo where login = :login",
        mapOf(
            "login" to login
        ),
        ROW_MAPPER).firstOrNull()

    override fun create(login: String, password: String, email: String) {
        TODO("Not yet implemented")
    }

    private companion object{
        val ROW_MAPPER = RowMapper<User>{ rs, _ ->
            User(
                id = rs.getInt("id"),
                login = rs.getString("login"),
                password = rs.getString("password"),
                email = rs.getString("email")
            )
        }
    }
}