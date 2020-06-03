package com.REST.WordAPI.DAO

import com.REST.WordAPI.Mapper.WordMapper
import com.REST.WordAPI.Model.Word
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository


@Repository
class WordDaoImpl : WordDao {


    fun WordDaoImpl(template: NamedParameterJdbcTemplate?) {
        this.template = template
    }

    var template: NamedParameterJdbcTemplate? = null


    override fun findAll(): List<Word?>? {
        return template?.query("select * from word;", WordMapper())
    }

    override fun insertWord(w: Word?) {
        val sql = "insert into word(word values(:w);"
        val holder: KeyHolder = GeneratedKeyHolder()
        val param: SqlParameterSource = MapSqlParameterSource().addValue("w", w?.getWord())
        template?.update(sql, param, holder)
    }


}