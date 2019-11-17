package com.example.services;

import com.example.model.Actor;
import com.example.payload.FullActorResponse;
import com.example.payload.NewActorRequest;
import com.example.payload.SimpleActorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {
    Actor newActor(NewActorRequest newActorRequest);
    Page<SimpleActorResponse> getAllActors(Pageable pageable);
    FullActorResponse findActorById(Long actorId);
}
