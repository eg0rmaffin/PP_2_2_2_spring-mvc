package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final List<Car> cars;

    public CarServiceImpl() {
        this.cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2022));
        cars.add(new Car("Honda", "Civic", 2005));
        cars.add(new Car("Ford", "Fusion", 2034));
        cars.add(new Car("Chevrolet", "Cruze", 2001));
        cars.add(new Car("BMW", "X5", 2023 ));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getCars(int count) {
        if (count >= cars.size() || count <= 0) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
