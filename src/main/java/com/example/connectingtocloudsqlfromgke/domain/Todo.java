package com.example.connectingtocloudsqlfromgke.domain;


import lombok.Getter;

import java.util.UUID;

@Getter
public class Todo {
    private final String id;
    private final String name;
    private final String description;

    public Todo(String name, String description) {
        this.id = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.description = description;
    }
}
