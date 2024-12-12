package ru.vaidom.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vaidom.model.Car;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarBySeries(int series) {
        Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car c where c.series = :series", Car.class);
        query.setParameter("series", series);
        return query.uniqueResult();
    }

    @Override
    public Car getCarByModel(String model) {
        Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car c where c.model = :model", Car.class);
        query.setParameter("model", model);
        return query.uniqueResult();
    }

    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car c where c.model = :model and c.series = :series", Car.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.uniqueResult();
    }
}
