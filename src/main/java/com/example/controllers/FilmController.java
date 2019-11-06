package com.example.controllers;

import com.example.model.Film;
import com.example.payload.*;
import com.example.services.ActorService;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
public class FilmController {

    private FilmService filmService;
    private ActorService actorService;

    public FilmController(FilmService filmService, ActorService actorService) {
        this.filmService = filmService;
        this.actorService = actorService;
    }

    //    @GetMapping("/films")
//    public Page<Film> getFilms(Pageable pageable) {
//        return filmService.findAllFilms(pageable);
//    }

    @GetMapping("/films")
    public List<SimpleFilmResponse> getFilms() {
        return filmService.findAllFilms();
    }

    @GetMapping("/films/{filmId}")
    public FullFilmResponse getFilm(@PathVariable Long filmId) {
        return filmService.findFilmById(filmId);
    }
    //@RequestBody odpowiada za to, ze jak przychodzi JSON to konwertuje go na film
    //a potem serializuje go na JSONA
    //@Valid uruchamia walidacje dla filmu (JSR-303)
//    ResponseEntity represents the whole HTTP response: status code, headers, and body.
//    Because of it, we can use it to fully configure the HTTP response.
//    If we want to use it, we have to return it from the endpoint;
    @PostMapping("/films")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> createFilm(@Valid @RequestBody NewFilmRequest newFilmRequest) {
        filmService.newFilm(newFilmRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Film Created Successfully"));
    }

    @PutMapping("/films/{filmId}")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> updateFilm(@PathVariable Long filmId, @Valid @RequestBody FilmUpdateRequest filmUpdateRequest) {
        filmService.updateFilm(filmId, filmUpdateRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Film updated"));
    }

    @DeleteMapping("films/{filmId}")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
        return ResponseEntity.ok(new ApiResponse(true, "Film deleted successfully"));
    }

    @PostMapping("films/{filmId}/actors")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> addActorToFilm(@PathVariable Long filmId, @Valid @RequestBody IdRequest idRequest) {
        filmService.addActorToFilm(filmId, idRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Actor added to film successfully"));
    }
}
