package com.francoiscoding.javatodos.service;

import com.francoiscoding.javatodos.models.Todo;
import com.francoiscoding.javatodos.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    Todo addTodo(Todo todo, long id);
}