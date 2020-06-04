package com.REST.WordAPI.Mapper

import com.REST.WordAPI.Model.User
import com.REST.WordAPI.Model.Word
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserMapper: RowMapper<Word> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, arg1: Int): User? {
        return User(userid = rs.getInt("userid"), username = rs.getString("username"), password = rs.getString("password"), highscore = rs.getInt("highscore"))
    }
}