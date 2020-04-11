package ru.itis.almaz.jsonserver.controller;

import org.springframework.web.bind.annotation.*;
import ru.itis.almaz.jsonserver.dto.TimetableFreeTimeByDate;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.dto.Timetable;
import ru.itis.almaz.jsonserver.model.FreeTime;
import ru.itis.almaz.jsonserver.repository.BusinessRepository;
import ru.itis.almaz.jsonserver.repository.FreeTimeRepository;

import java.util.List;

@RestController("/")
public class JsonController {

    final BusinessRepository businessRepository;
    final FreeTimeRepository freeTimeRepository;

    public JsonController(BusinessRepository businessRepository, FreeTimeRepository freeTimeRepository) {
        this.businessRepository = businessRepository;
        this.freeTimeRepository = freeTimeRepository;
    }

    @GetMapping("/timetable")
    public Timetable getTimeTable() {
        List<Business> businesses = businessRepository.findAll();
        return new Timetable(businesses);
    }

    @GetMapping("/timetable/date")
    @ResponseBody
    public List<FreeTime> getTimeTableByDate(@RequestParam(value = "date") String date) {
        List<FreeTime> freeTimes = freeTimeRepository.findFreeTimesByDate(date);
        return freeTimes;
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
