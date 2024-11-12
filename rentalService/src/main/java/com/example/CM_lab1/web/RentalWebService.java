package com.example.CM_lab1.web;

import com.example.CM_lab1.data.Car;
import com.example.CM_lab1.data.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RentalWebService {
    List<Car> cars = new ArrayList<Car>();

    Logger logger = LoggerFactory.getLogger(RentalWebService.class);

    public RentalWebService() {
        Car car = new Car("ABC-1234", 100, "Toyota");
        cars.add(car);
        car = new Car("DEF-5678", 200, "Honda");
        cars.add(car);
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> getCars(){
        return cars;
    }

    @GetMapping("/cars/{plate}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car getCar(@PathVariable("plate") String plateNumber) throws CarNotFoundException {
        for (Car car : cars){
            if (car.getPlateNumber().equals(plateNumber)){
                return car;
            }
        }
        logger.error("No car with the plate number " + plateNumber + " found");
        throw new CarNotFoundException("No car with the plate number " + plateNumber + " found");
    }

    // command to test in PS : curl.exe --header "Content-Type: application/json" --request PUT --data '{\"begin\":\"4/11/2024\",\"end\":\"20/11/2024\"}' http://localhost:8080/cars/ABC-1234?rent=true
    @PutMapping(value = "/cars/{plate}")
    // chercher la car avec la bonne plaque
    // si demande de loc => mettre la voiture loué
    // sinon mettre la voiture dispo
    public void rent(
            @PathVariable("plate") String plateNumber,
            @RequestParam(value="rent", required = true)Boolean rent,
            @RequestBody Dates dates) throws Exception{
        for (Car car : cars){
            if (car.getPlateNumber().equals(plateNumber)){
                if (rent){
                    if (car.getRented()) {
                        logger.error("Car " + car.getPlateNumber() + " is already rented");
                        throw new CarAlreadyRentedException("Car " + car.getPlateNumber() + " is already rented");
                    }
                    if (!car.addDates(dates)) throw new Exception("error when adding dates to the car");
                    car.setRented(true);
                    logger.info("Renting car " + car.getPlateNumber() + " from " + dates.getBegin() + " to " + dates.getEnd());
                } else {
                    if (!car.getRented()) throw new Exception("Car already available");
                    if (!car.removeDates(dates)) throw new Exception("error when removing dates from the car");
                    car.setRented(false);
                    logger.info("Getting back car " + car.getPlateNumber());
                }
                return;
            }
        }
        throw new CarNotFoundException("No car with the plate number " + plateNumber + " found");
    }
}
