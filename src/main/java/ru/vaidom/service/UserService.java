package ru.vaidom.service;

import ru.vaidom.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
}
