package ru.itis.almaz.jsonserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.model.Cabinet;
import ru.itis.almaz.jsonserver.model.Status;
import ru.itis.almaz.jsonserver.model.Time;
import ru.itis.almaz.jsonserver.dto.Timetable;
import ru.itis.almaz.jsonserver.repository.BusinessRepository;
import ru.itis.almaz.jsonserver.repository.CabinetRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/")
public class JsonController {

    final BusinessRepository repository;

    public JsonController(BusinessRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/timetable")
    public Timetable getTimeTable() {
        repository.
        List<Business> businesses = repository.findAll();
        return new Timetable(businesses);
    }

    /*@PostMapping
    public ResponseEntity<Cabinet> setCabinet(@RequestBody Cabinet cabinetBody) {
        Cabinet cabinet = repository.save(cabinetBody);

        return ResponseEntity.ok(cabinet);
    }*/

/*
    @GetMapping("/setter1")
    public void setter() {
        Map<Time, Status> business = Map.of(Time.FirstClass, Status.Free, Time.SecondClass, Status.Booked, Time.ThirdClass, Status.Booked);
        Cabinet cabinet = Cabinet.builder()
                .id(1L)
                .number(1301)
                .capacity(20)
                .business(business)
                .build();
        repository.save(cabinet);
    }

    @GetMapping("/setter2")
    public void setter2() {
        Map<Time, Status> business = Map.of(Time.FirstClass, Status.Booked, Time.SecondClass, Status.Booked, Time.ThirdClass, Status.Booked);
        Cabinet cabinet = Cabinet.builder()
                .id(1L)
                .number(1302)
                .capacity(20)
                .business(business)
                .build();
        repository.save(cabinet);
    }
*/

}
