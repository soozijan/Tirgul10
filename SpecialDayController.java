package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SpecialDayController {

    private static SpecialDayDAO specialDayDAO = new SpecialDayDAO("jdbc:sqlite:c:/SQlight/calendar.db");

    @GetMapping("/specialDay")
    public ArrayList<SpecialDay> getSpeciakDay() {
        ArrayList<SpecialDay> specialDays = specialDayDAO.getAllSpecialDay();
        return specialDays;
    }

    @GetMapping("/specialDay/{id}")
    public SpecialDay doGetSpecialDayById(@PathVariable("id") int id) {
        SpecialDay specialDay = specialDayDAO.getSpecialDayById(id);
        return specialDay;
    }

    @PostMapping("/post-specialDay")
    public void addSpecialDay(@RequestBody SpecialDay specialDay) {
        specialDayDAO.insertSpecialDay(specialDay);
    }

    @PutMapping("/put-specialDay/{id}")
    public void updateSpecialDay(@PathVariable("id") int id, @RequestBody SpecialDay update_specialDay) {
        specialDayDAO.updateSpecialDay(update_specialDay, id);
    }

    @DeleteMapping("/delete-specialDay/{id}")
    public void delSpecialDayById(@PathVariable("id") int id) {
        specialDayDAO.deleteSpecialDay(id);
    }
}
