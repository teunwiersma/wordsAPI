package com.REST.WordAPI.DAO

import com.REST.WordAPI.Domain.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import java.sql.ResultSet


@Repository
class WordDaoImpl : WordDao {

    @Autowired
    private var template: NamedParameterJdbcTemplate? = null

    fun WordDaoImpl(template: NamedParameterJdbcTemplate?) {
        this.template = template
    }

    var rowMapper: RowMapper<Word> = RowMapper<Word> { resultSet: ResultSet, rowIndex: Int ->
        Word(resultSet.getString("word") )}

    override fun findAll(): List<Word?>? {
        return template?.query("select * from word", rowMapper)
    }

    override fun insertWord(word: Word) {
        val sql = "insert into word (word) values(:word)"
        val holder: KeyHolder = GeneratedKeyHolder()
        val param: SqlParameterSource = MapSqlParameterSource().addValue("word", word.getWord())
        template!!.update(sql, param, holder)
    }

}