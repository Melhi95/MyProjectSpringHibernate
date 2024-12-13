package ru.vaidom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vaidom.dao.UserDao;
import ru.vaidom.model.User;

import java.util.List;

@RequiredArgsConstructor

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
