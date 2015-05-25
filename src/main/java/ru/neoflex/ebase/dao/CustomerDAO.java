package ru.neoflex.ebase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import ru.neoflex.ebase.model.Customer;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.neoflex.ebase.model.Role;

/**
 * Created by kshahin on 5/15/2015.
 */
public class CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerDAO(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Customer getByLogin(String login) {
        String sql = "SELECT * FROM customers WHERE login = ?";

        //List<Role> roles =
        final List<Role> roles = jdbcTemplate.query(
                "SELECT * FROM roles WHERE login = ?", new Object[] { login },
                new RowMapper<Role>() {
                    @Override
                    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Role(rs.getLong("id"), rs.getString("login"),
                                rs.getString("name"));
                    }
                });

        return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setLogin(rs.getString("login"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPassword(rs.getString("password"));
                    customer.setName(rs.getString("name"));
                    customer.setLastName(rs.getString("lastname"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setRoles(roles);
                    return customer;
                }

                return null;
            }

        }, login);
    }
}
