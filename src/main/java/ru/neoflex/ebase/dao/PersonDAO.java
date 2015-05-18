package ru.neoflex.ebase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import ru.neoflex.ebase.model.Person;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
/**
 * Created by kshahin on 5/15/2015.
 */
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonDAO(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person getByLogin(String login) {
        String sql = "SELECT * FROM persons WHERE login = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Person>() {

            @Override
            public Person extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getLong("id"));
                    person.setLogin(rs.getString("login"));
                    person.setEmail(rs.getString("email"));
                    person.setPassword(rs.getString("password"));
                    person.setName(rs.getString("name"));
                    person.setLastName(rs.getString("lastname"));
                    person.setPhone(rs.getString("phone"));
                    person.setRole(rs.getString("role"));
                    return person;
                }

                return null;
            }

        }, login);
    }
}
