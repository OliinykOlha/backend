package de.ait.hw20250507_1.controllers;

import de.ait.hw20250507_1.model.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    @GetMapping("/now")
    public DateTime getTime() {
        LocalDateTime now = LocalDateTime.now();
       return DateTime.builder()
                .day(now.getDayOfMonth())
                .month(now.getMonthValue())
                .year(now.getYear())
                .build();
    }
}
