package com.example.controllers;

import com.example.model.Film;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public Page<Film> getFilms(Pageable pageable) {
        return filmService.findAllFilms(pageable);
    }

    //@RequestBody odpowiada za to, ze jak przychodzi JSON to konwertuje go na film
    //a potem serializuje go na JSONA
    //@Valid uruchamia walidacje dla filmu (JSR-303)
//    ResponseEntity represents the whole HTTP response: status code, headers, and body.
//    Because of it, we can use it to fully configure the HTTP response.
//    If we want to use it, we have to return it from the endpoint;
    @PostMapping("/films")
    @RolesAllowed("ROLE_USER")
    public Film createFilm(@Valid @RequestBody Film film) {
//        return ResponseEntity.accepted().body(filmService.newFilm(film));
        return filmService.newFilm(film);
    }

    @PutMapping("/films/{filmId}")
    public Film updateFilm(@PathVariable Long filmId, @Valid @RequestBody Film filmRequest) {
        return filmService.updateFilm(filmId, filmRequest);
    }

    @DeleteMapping("films/{filmId}")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
        return ResponseEntity.ok().build();
    }
}
