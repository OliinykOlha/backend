package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class DemoRestController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Curious George", "H.A.Rey", 2000, "235981"));
        books.add(new Book("Harry Potter", "J.K.Rowling", 2000, "236458"));
        books.add(new Book("Holes", "C.S.Lewis", 2016, "226409"));

        return books;
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<Film> getFilm() {
        List<Film> films = new ArrayList<>();
        films.add(new Film("Action", "2010", "Inception", 236457));
        films.add(new Film("Comedy", "2014", "The Grand Budapest Hotel", 236458));
        films.add(new Film("Drama", "2018", "A Quiet Place", 236459));

        return films;
    }


    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public DateDto getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return new DateDto(day, month, year, hour, minute, second);
    }
}
