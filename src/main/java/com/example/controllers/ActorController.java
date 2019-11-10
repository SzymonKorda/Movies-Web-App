package com.example.controllers;

import com.example.payload.*;
import com.example.services.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/actors")
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> createActor(@Valid @RequestBody NewActorRequest newActorRequest) {
        actorService.newActor(newActorRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Actor Created Successfully"));
    }

    @GetMapping("/actors")
    public List<SimpleActorResponse> getActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/actors/{actorId}")
    public FullActorResponse getActor(@PathVariable Long actorId) {
        return actorService.findActorById(actorId);
    }

}
