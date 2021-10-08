package com.example.connectingtocloudsqlfromgke.services;

import com.example.connectingtocloudsqlfromgke.domain.Todo;
import com.example.connectingtocloudsqlfromgke.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Optional<Todo> saveTodo(final Todo todo) {
        return this.todoRepository.saveBid(todo);
    }
}
