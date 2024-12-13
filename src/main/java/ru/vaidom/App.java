package ru.vaidom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vaidom.config.AppConfig;
import ru.vaidom.model.Car;
import ru.vaidom.model.User;
import ru.vaidom.service.CarService;
import ru.vaidom.service.UserService;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.addUser(User.builder()
                        .firstName("Вася")
                        .lastName("Печкин")
                        .email("vasya@gmail.com")
                        .car(Car.builder()
                                .model("BMW")
                                .series(123)
                                .build())
                        .build());

        userService.addUser(User.builder()
                        .firstName("Ivan")
                        .lastName("Ivanov")
                        .email("ivanov@gmail.com")
                        .car(Car.builder()
                                .model("Лада")
                                .series(456)
                                .build())
                        .build());

        userService.addUser(User.builder()
                        .firstName("Юлий")
                        .lastName("Цезарь")
                        .email("salat@gmail.com")
                        .car(Car.builder()
                                .model("Конь")
                                .series(1)
                                .build())
                        .build());

        for (User user : userService.getUsers()) {
            System.out.println(user);
        }

        System.out.println();
        System.out.println(carService.getCarByModel("Конь").getUser());
        System.out.println(carService.getCarBySeries(123).getUser());
        System.out.println(carService.getCarByModelAndSeries("Лада", 456).getUser());

        context.close();
    }
}
