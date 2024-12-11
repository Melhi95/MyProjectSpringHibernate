package ru.vaidom.dao;


import ru.vaidom.model.Car;

public interface CarDao {
    Car getCarBySeries(int series);
    Car getCarByModel(String model);
    Car getCarByModelAndSeries(String model, int series);
}
