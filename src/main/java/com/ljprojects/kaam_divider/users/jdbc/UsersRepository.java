package com.ljprojects.kaam_divider.users.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ljprojects.kaam_divider.users.Users;

@Repository // annnoation used for a class to talk to a database
public class UsersRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String insert_query = """
                insert into users (id, name, password)
                values(?, ?, ?);
            """;

    private static String delete_query = """
                delete from users where id = ?;
            """;

    private static String select_query = """
                select * from users where id = ?;
            """;

    public void insert(Users users) {
        springJdbcTemplate.update(insert_query, users.getId(), users.getName(), users.getPassword());
    }

    public void deleteById(Long id) {
        springJdbcTemplate.update(delete_query, id);
    }

    public Users findById(Long id) {
        return springJdbcTemplate.queryForObject(select_query, new BeanPropertyRowMapper<>(Users.class), id);
        // second paarmeter helps us to map Resultset to Bean
        // As we have same bean and table variables names , we can use
        // BeanPropertyRowMapper
    }
}
