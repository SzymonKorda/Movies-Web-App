package com.example.services;

import com.example.model.Actor;
import com.example.payload.NewActorRequest;

public interface ActorService {
    Actor newActor(NewActorRequest newActorRequest);
}
