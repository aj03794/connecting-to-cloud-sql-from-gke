package com.example.connectingtocloudsqlfromgke.controllers;

import com.example.connectingtocloudsqlfromgke.domain.Todo;
import com.example.connectingtocloudsqlfromgke.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody final Todo todo) {
        var savedTodo = this.todoService.saveTodo(todo);
        return savedTodo
                .map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
