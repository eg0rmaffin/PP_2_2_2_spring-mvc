package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, ModelMap model) {
        List<Car> cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
