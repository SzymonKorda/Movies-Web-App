package com.example.controllers;

import com.example.payload.*;
import com.example.services.ActorService;
import com.example.services.FilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class ActorController {

    private ActorService actorService;
    private FilmService filmService;

    public ActorController(ActorService actorService, FilmService filmService) {
        this.actorService = actorService;
        this.filmService = filmService;
    }

    @PostMapping("/actors")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createActor(@Valid @RequestBody NewActorRequest newActorRequest) {
        actorService.newActor(newActorRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Actor Created Successfully"));
    }

    @DeleteMapping("/actors/{actorId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> deleteActor(@PathVariable Long actorId) {
        actorService.deleteActorById(actorId);
        return ResponseEntity.ok(new ApiResponse(true, "Actor deleted successfully"));
    }

    @PostMapping("/actors/{actorId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> updateActor(@PathVariable Long actorId, @Valid @RequestBody ActorUpdateRequest actorUpdateRequest) {
        actorService.updateActor(actorId, actorUpdateRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Actor updated"));
    }

    @GetMapping("/actors")
    public Page<SimpleActorResponse> getActors(Pageable pageable) {
        return actorService.getAllActors(pageable);
    }

    @GetMapping("/actors/{actorId}")
    public FullActorResponse getActor(@PathVariable Long actorId) {
        return actorService.findActorById(actorId);
    }

    @GetMapping("/actors/{actorId}/films")
    public Page<SimpleFilmResponse> getFilms(@PathVariable Long actorId, Pageable pageable) {
        return filmService.getByActorId(pageable, actorId);
    }

}
