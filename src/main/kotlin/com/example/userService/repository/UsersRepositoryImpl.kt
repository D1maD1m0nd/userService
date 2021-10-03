package com.example.userService.repository

import com.example.userService.model.User
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl(
    private val jdbcTemplate : NamedParameterJdbcTemplate
) : UsersRepository {
    override fun getByLogin(login: String): User? =
        jdbcTemplate.query(
            "select * from users where login = :login",
            mapOf(
                "login" to login
            ),
            ROW_MAPPER
        ).firstOrNull()

    override fun create(login: String, password: String, email: String): Int {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into users (login, password, email) values (:login, :password, :email)",
            MapSqlParameterSource(
                mapOf(
                    "login" to login,
                    "password" to password,
                    "email" to email
                )
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return keyHolder.keys?.getValue("id") as Int
    }

    private companion object {
        val ROW_MAPPER = RowMapper<User> { rs, _ ->
            User(
                id = rs.getInt("id"),
                login = rs.getString("login"),
                password = rs.getString("password"),
                email = rs.getString("email")
            )
        }
    }
}