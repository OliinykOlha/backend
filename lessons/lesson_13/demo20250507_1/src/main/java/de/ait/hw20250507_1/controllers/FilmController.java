package de.ait.hw20250507_1.controllers;

import de.ait.hw20250507_1.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {

    private static List<Film> filmDb = new ArrayList<>(
            List.of(new Film("Tommorow", 2000),
                    new Film("Piter", 2011))
    );

    @GetMapping("/films")
    public List<Film> getFilms() {
        return filmDb;
    }
}
