package com.motouser.controller;

import com.motouser.model.Driver;
import com.motouser.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

@CrossOrigin
@Controller
@RequestMapping ("/api/driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @GetMapping
    public Flux<Driver> getAllDrivers () {
        return driverRepository.findAll();
    }

    @PostMapping
    public Mono<Driver> postDriver (@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @PutMapping ("/{id}")
    public Mono<Driver> putDriver(@PathVariable String id, @RequestBody Driver driver)
    {
        return driverRepository.findById(id).flatMap(oldDriver->{
            oldDriver.setAge(driver.getAge());
            oldDriver.setName(driver.getName());
            oldDriver.setMotoList(driver.getMotoList());
            return driverRepository.save(oldDriver);
        });
    }

    @DeleteMapping ("/{id}")
    public void delDriver (@PathVariable String id) {
        driverRepository.deleteById(id);
        System.out.println("Driver #"+id+" was deleted!");
    }

    @DeleteMapping
    public void delAll () {
        driverRepository.deleteAll();
        System.out.println("All drivers were deleted!");
    }
}
