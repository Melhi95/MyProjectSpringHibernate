package ru.vaidom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vaidom.dao.CarDao;
import ru.vaidom.model.Car;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;


    @Transactional(readOnly = true)
    @Override
    public Car getCarBySeries(int series) {
        return carDao.getCarBySeries(series);
    }

    @Transactional(readOnly = true)
    @Override
    public Car getCarByModel(String model) {
        return carDao.getCarByModel(model);
    }

    @Transactional(readOnly = true)
    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        return carDao.getCarByModelAndSeries(model, series);
    }
}
