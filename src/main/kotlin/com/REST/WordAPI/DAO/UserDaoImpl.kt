package com.REST.WordAPI.DAO
import com.REST.WordAPI.Domain.User
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
class UserDaoImpl : UserDao {

    @Autowired
    private var template: NamedParameterJdbcTemplate? = null

    var rowMapper: RowMapper<User> = RowMapper<User> { resultSet: ResultSet, rowIndex: Int ->
        User( resultSet.getString("username"),resultSet.getInt("highscore"))
    }

    override fun findAll(): List<User?>? {
        return template?.query("select * from users ORDER BY highscore DESC LIMIT 5", rowMapper)
    }

    override fun insertUser(user: User) {
        val sql = "insert into users (username, highscore) values(:username, :highscore)"
        val holder: KeyHolder = GeneratedKeyHolder()
        val param: SqlParameterSource = MapSqlParameterSource().addValue("username", user.getUserName())
                .addValue("highscore", user.getHighscore())
        template!!.update(sql, param, holder)
    }
}

