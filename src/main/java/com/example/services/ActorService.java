package com.example.services;

import com.example.model.Actor;
import com.example.payload.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {
    Actor newActor(NewActorRequest newActorRequest);
    Page<SimpleActorResponse> getAllActors(Pageable pageable);
    FullActorResponse findActorById(Long actorId);
    Page<SimpleActorResponse> getByFilmId(Pageable pageable, Long filmId);
    void deleteActorById(Long actorId);
    Actor updateActor(Long actorId, ActorUpdateRequest actorUpdateRequest);
    void addFilmToActor(Long actorId, Long filmId);
    void deleteActorFilm(Long actorId, Long filmId);
    Page<ActorChoiceResponse> getActorsChoices(Pageable pageable, Integer pageNo, Integer pageSize, String sortBy, String order);
}
