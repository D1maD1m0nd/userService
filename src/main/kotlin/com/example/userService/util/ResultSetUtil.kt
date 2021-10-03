package com.example.userService.util

import java.sql.ResultSet


fun ResultSet.getIntOrNull(column : String) : Int?{
    val value = this.getInt(column)
    if(this.wasNull()) {
        return null
    }
    return value
}