package com.example.controllers;

import com.example.payload.ApiResponse;
import com.example.payload.NewActorRequest;
import com.example.payload.NewFilmRequest;
import com.example.services.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

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
}
