package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HolidayController {

    private static HolidayDAO holidayDAO = new HolidayDAO("jdbc:sqlite:c:/SQlight/calendar.db");

    @GetMapping("/holiday")
    public ArrayList<Holiday> getHoliday(){
        ArrayList<Holiday> holidays = holidayDAO.getAllHolidays();
        return holidays;
    }

    @GetMapping("/holiday/{id}")
    public Holiday doGetHolidayById(@PathVariable("id") int id)
    {
        Holiday holiday = holidayDAO.getHolidayById(id);
        return holiday;
    }

    @PostMapping("/post-holiday")
    public void addHoliday(@RequestBody Holiday holiday)
    {
        holidayDAO.insertHoliday(holiday);
    }

    @PutMapping("/put-holiday/{id}")
    public void updateHoliday(@PathVariable("id") int id, @RequestBody Holiday update_holiday)
    {
        holidayDAO.updateHoliday(update_holiday, id);
    }

    @DeleteMapping("/delete-holiday/{id}")
    public void delHolidayById(@PathVariable("id") int id)
    {
        holidayDAO.deleteHoliday(id);
    }

}
