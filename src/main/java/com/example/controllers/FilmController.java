package com.example.controllers;

import com.example.model.Film;
import com.example.repositories.FilmRepository;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public Film createFilm(@Valid @RequestBody Film film) {
        return filmService.newFilm(film);
    }

    @PutMapping("/films/{filmId}")
    public Film updateFilm(@PathVariable Long filmId, @Valid @RequestBody Film filmRequest) {
        return filmService.updateFilm(filmId, filmRequest);
    }

    @DeleteMapping("films/{filmId}")
    public void deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        } ));

        return errors;
    }
}
