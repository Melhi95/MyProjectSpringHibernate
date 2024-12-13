package ru.vaidom.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.vaidom.model.User;

import java.util.List;

@RequiredArgsConstructor

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }
}
