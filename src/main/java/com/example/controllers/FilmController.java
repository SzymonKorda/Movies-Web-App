package com.example.controllers;

import com.example.specification.FilmSpecification;
import com.example.payload.*;
import com.example.security.CurrentUser;
import com.example.security.UserPrincipal;
import com.example.services.ActorService;
import com.example.services.CommentService;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class FilmController {

    private FilmService filmService;
    private ActorService actorService;
    private CommentService commentService;


    public FilmController(FilmService filmService, ActorService actorService,
                          CommentService commentService) {
        this.filmService = filmService;
        this.actorService = actorService;
        this.commentService = commentService;
    }

    @GetMapping("/films")
    public Page<SimpleFilmResponse> getFilms(FilmSpecification filmSpecification, Pageable pageable) {
        return filmService.findAllFilms(filmSpecification, pageable);
    }


    @GetMapping("films/{filmId}/comments")
    public Page<CommentResponse> getComments(@PathVariable Long filmId, Pageable pageable) {
        return commentService.getByFilmId(pageable, filmId);
    }

    @GetMapping("films/{filmId}/actors")
    public Page<SimpleActorResponse> getActors(@PathVariable Long filmId, Pageable pageable) {
        return actorService.getByFilmId(pageable, filmId);
    }


    @GetMapping("/films/{filmId}")
    public FullFilmResponse getFilm(@PathVariable Long filmId) {
        return filmService.findFilmById(filmId);
    }


    @PostMapping("/films")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createFilm(@Valid @RequestBody NewFilmRequest newFilmRequest) {
        filmService.newFilm(newFilmRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Film Created Successfully"));
    }


    @PostMapping("/films/{filmId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> updateFilm(@PathVariable Long filmId, @Valid @RequestBody FilmUpdateRequest filmUpdateRequest) {
        filmService.updateFilm(filmId, filmUpdateRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Film updated"));
    }

    @DeleteMapping("films/{filmId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> deleteFilm(@PathVariable Long filmId) {
        filmService.deleteFilmById(filmId);
        return ResponseEntity.ok(new ApiResponse(true, "Film deleted successfully"));
    }

    @PostMapping("films/{filmId}/actors/{actorId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> addActorToFilm(@PathVariable Long filmId, @PathVariable Long actorId) {
        filmService.addActorToFilm(filmId, actorId);
        return ResponseEntity.ok(new ApiResponse(true, "Actor added to film successfully"));
    }

    @PostMapping("films/{filmId}/comments")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> addCommentToFilm(@CurrentUser UserPrincipal currentUser, @PathVariable Long filmId, @Valid @RequestBody NewCommentRequest newCommentRequest) {
        filmService.addCommentToFilm(currentUser, filmId, newCommentRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Comment added to film successfully"));
    }

    @PostMapping("/films/{filmId}/favourites")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> addFilmToUser(@CurrentUser UserPrincipal currentUser, @PathVariable Long filmId) {
        filmService.addFilmToUser(currentUser, filmId);
        return ResponseEntity.ok(new ApiResponse(true, "Film added to user successfully"));
    }

    @DeleteMapping("/films/{filmId}/actors/{actorId}")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<?> deleteActorFilm(@PathVariable Long filmId, @PathVariable Long actorId) {
        filmService.deleteActorFilm(filmId, actorId);
        return ResponseEntity.ok(new ApiResponse(true, "Film's actor deleted successfully"));
    }

    @GetMapping("/films/choices")
    public Page<FilmChoiceResponse> getFilmsChoices(FilmSpecification filmSpecification, Pageable pageable) {
        return filmService.getFilmsChoices(filmSpecification, pageable);
    }
}


