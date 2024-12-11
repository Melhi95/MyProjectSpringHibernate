package ru.vaidom.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vaidom.model.Car;
import ru.vaidom.model.User;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarBySeries(int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car c where c.series = :series");
        query.setParameter("series", series);
        return (Car) query.uniqueResult();
    }

    @Override
    public Car getCarByModel(String model) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car c where c.model = :model");
        query.setParameter("model", model);
        return (Car) query.uniqueResult();
    }

    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car c where c.model = :model and c.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return (Car) query.uniqueResult();
    }
}
