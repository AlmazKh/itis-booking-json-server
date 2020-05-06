package ru.itis.almaz.jsonserver.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.almaz.jsonserver.dto.TimetableFreeTimeByDate;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.dto.Timetable;
import ru.itis.almaz.jsonserver.model.FreeTime;
import ru.itis.almaz.jsonserver.model.Usr;
import ru.itis.almaz.jsonserver.repository.BusinessRepository;
import ru.itis.almaz.jsonserver.repository.FreeTimeRepository;
import ru.itis.almaz.jsonserver.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController("/")
public class JsonController {

    final BusinessRepository businessRepository;
    final FreeTimeRepository freeTimeRepository;
    final UserRepository userRepository;

    public JsonController(BusinessRepository businessRepository, FreeTimeRepository freeTimeRepository, UserRepository userRepository) {
        this.businessRepository = businessRepository;
        this.freeTimeRepository = freeTimeRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    @ResponseBody
    public Usr getUserByEmail(@RequestParam(value = "email") String email) {
        return userRepository.findUsrByEmail(email);
    }

    @GetMapping("/timetable")
    public Timetable getTimeTable() {
        List<Business> businesses = businessRepository.findAll();
        return new Timetable(businesses);
    }

    @GetMapping("/timetable/free")
    @ResponseBody
    public List<FreeTime> getTimeTableByDate(@RequestParam(value = "date") String date) {
        return freeTimeRepository.findFreeTimesByDate(date);
    }

    @GetMapping("/timetable/free/filtered")
    @ResponseBody
    public List<FreeTime> findFreeTimesByDateAndAndCabinet_CapacityAndCabinet_Floor(
            @RequestParam("date") String date,
            @RequestParam("times") List<String> times,
            @RequestParam("floors") List<Integer> floors,
            @RequestParam("capacity") Integer capacity
    ) {
        return freeTimeRepository
                .findFreeTimesByDateAndAndCabinet_CapacityAndCabinet_Floor(
                        date,
                        times,
                        floors,
                        capacity
                );
    }

    @GetMapping("/business/filtered")
    @ResponseBody
    public List<Business> findBookedTimesByFilter(
            @RequestParam("date") String date,
            @RequestParam("times") List<String> times,
            @RequestParam("floors") List<Integer> floors,
            @RequestParam("capacity") Integer capacity,
            @RequestParam("priority") Integer priority
    ) {
        return businessRepository.findBookedTimesByFilter(
                date,
                times,
                floors,
                capacity,
                priority
        );
    }

    @GetMapping("/business/withfree/filtered")
    @ResponseBody
    public List<Business> findFreeAndBookedTimesByFilter(
            @RequestParam("date") String date,
            @RequestParam("times") List<String> times,
            @RequestParam("floors") List<Integer> floors,
            @RequestParam("capacity") Integer capacity,
            @RequestParam("priority") Integer priority
    ) {
        return businessRepository.findFreeAndBookedTimesByFilter(
                date,
                times,
                floors,
                capacity,
                priority
        );
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Business> bookCabinet(@RequestBody Business businessBody) {
        Business business = businessRepository.save(businessBody);

        return ResponseEntity.ok(business);
    }

    @GetMapping("/user/bookings")
    @ResponseBody
    public List<Business> getUserBookings(@RequestParam(value = "id") Long userId) {
        return businessRepository.findBusinessesByUsrId(userId);
    }

    @PostMapping(value = "/user/bookings/delete")
    public ResponseEntity cancelBooking(@RequestBody Long id) {
        businessRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/map")
    @ResponseBody
    public List<Integer> getMapBookingCabinet(
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "floor") Integer floor) {
        List<Integer> list = new ArrayList<>();
        List<Business> businesses = businessRepository.findMapBusinesses(date, time, floor);

        for (Business elt : businesses) {
            list.add(elt.getCabinet().getNumber());
        }

        return list;
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
