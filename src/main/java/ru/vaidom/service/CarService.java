package ru.vaidom.service;


import ru.vaidom.model.Car;

public interface CarService {
    Car getCarBySeries(int series);
    Car getCarByModel(String model);
    Car getCarByModelAndSeries(String model, int series);
}
