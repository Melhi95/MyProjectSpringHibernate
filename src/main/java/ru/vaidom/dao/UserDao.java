package ru.vaidom.dao;

import ru.vaidom.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getUsers();
}
