package com.REST.WordAPI.Mapper

import com.REST.WordAPI.Domain.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserMapper: RowMapper<User> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, arg1: Int): User? {
        return User(name = rs.getString("username"), highscore = rs.getInt("highscore"))
    }
}