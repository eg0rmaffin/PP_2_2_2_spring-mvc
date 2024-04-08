package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, ModelMap model) {
            List<Car> cars;
            if (count <= 0 || count >= carService.getAllCars().size()) {
                cars = carService.getAllCars();
            } else {
                cars = carService.getCars(count);
            }
            model.addAttribute("cars", cars);
            return "cars";
    }
}
