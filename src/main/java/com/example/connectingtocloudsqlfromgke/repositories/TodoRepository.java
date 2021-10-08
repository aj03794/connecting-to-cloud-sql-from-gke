package com.example.connectingtocloudsqlfromgke.repositories;

import com.example.connectingtocloudsqlfromgke.domain.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class TodoRepository {

    @Value("${DB_PASS}")
    private String password;

    @Value("${DB_USER}")
    private String user;

    @Value("${DB_NAME}")
    private String dbName;

    private static final String INSERT_TODO = "insert into todos"
            + " (id, name, description)"
            + " VALUES (:id, :name, :description)";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TodoRepository(final DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Optional<Todo> saveBid(final Todo todo) {
        System.out.println("password: " + password);
        System.out.println("user: " + user);
        System.out.println("dbName: " + dbName);
        var parameters = new MapSqlParameterSource();
        parameters.addValue("id", todo.getId());
        parameters.addValue("name", todo.getName());
        parameters.addValue("description", todo.getDescription());
        try {
            namedParameterJdbcTemplate.update(INSERT_TODO, parameters);
            return Optional.of(todo);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
