package com.francoiscoding.javatodos.service;

import com.francoiscoding.javatodos.models.Todo;

import java.util.List;

public interface TodoService {
    Todo update(Todo todo, long id);

}