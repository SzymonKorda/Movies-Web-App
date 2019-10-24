package com.example.controllers;

import com.example.exceptions.UniqueConstraintException;
import com.example.model.Film;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/films")
    public ResponseEntity<Film> createFilm(@Valid @RequestBody Film film) {
        return ResponseEntity.accepted().body(filmService.newFilm(film));
    }

    @PutMapping("/films/{filmId}")
    public Film updateFilm(@PathVariable Long filmId, @Valid @RequestBody Film filmRequest) {
        return filmService.updateFilm(filmId, filmRequest);
    }

    @DeleteMapping("films/{filmId}")
    public void deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(UniqueConstraintException.class)
//    public List<String> handleValidationExceptions(SQLException ex) {
//        System.out.println("CZY JA SIE TU W OGOLE ZNALAZLEM");
//        List<String> errors = new ArrayList<>();
//        errors.add(ex.getSQLState());
//        errors.add(Integer.toString(ex.getErrorCode()));
//        errors.add(ex.getMessage());
//
//        return errors;
//    }



}
