package com.francoiscoding.javatodos;

import com.francoiscoding.javatodos.models.Role;
import com.francoiscoding.javatodos.models.Todo;
import com.francoiscoding.javatodos.models.User;
import com.francoiscoding.javatodos.models.UserRoles;
import com.francoiscoding.javatodos.repos.RoleRepository;
import com.francoiscoding.javatodos.repos.TodoRepository;
import com.francoiscoding.javatodos.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;
    TodoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, TodoRepository todorepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("Austin", "password", admins);
        User u2 = new User("admin", "password", admins);
        User u3 = new User("Test", "password", users);
        User u4 = new User("Test2", "password", users);

        // the date and time string should get coverted to a datetime Java data type. This is done in the constructor!
        u4.getTodoslist().add(new Todo("Finish java-orders-swagger", u4));
        u4.getTodoslist().add(new Todo("Feed the turtles", u4));
        u4.getTodoslist().add(new Todo("Complete the sprint challenge", u4));

        u3.getTodoslist().add(new Todo("Walk the dogs", u3));
        u3.getTodoslist().add(new Todo("provide feedback to my instructor", u3));

        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
    }
}