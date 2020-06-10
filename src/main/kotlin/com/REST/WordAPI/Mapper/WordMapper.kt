package com.REST.WordAPI.Mapper

import com.REST.WordAPI.Domain.Word
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException


class WordMapper : RowMapper<Word> {

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, arg1: Int): Word? {
        return Word( word = rs.getString("word"))
    }
}