package de.ait.demo.controllers;

public class Film {
     int id;
     String title;
     String year;
     String genre;

    public Film(String genre, String year, String title, int id) {
        this.genre = genre;
        this.year = year;
        this.title = title;
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
