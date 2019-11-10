package com.example.services;

import com.example.model.Actor;
import com.example.payload.NewActorRequest;
import com.example.payload.SimpleActorResponse;

import java.util.List;

public interface ActorService {
    Actor newActor(NewActorRequest newActorRequest);
    List<SimpleActorResponse> getAllActors();
}
