package com.example.services;

import com.example.model.Actor;
import com.example.payload.NewActorRequest;
import com.example.payload.SimpleActorResponse;
import com.example.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor newActor(NewActorRequest newActorRequest) {
        Actor actor = new Actor();
        actor.setFirstname(newActorRequest.getFirstname());
        actor.setLastname(newActorRequest.getLastname());
        actor.setHeight(newActorRequest.getHeight());

        return actorRepository.save(actor);
    }

    @Override
    public List<SimpleActorResponse> getAllActors() {
        List<Actor> actorsList = actorRepository.findAll();
        List<SimpleActorResponse> simpleActorResponseList = new ArrayList<>();

        for(Actor actor : actorsList) {
            SimpleActorResponse simpleActorResponse = new SimpleActorResponse();
            simpleActorResponse.setId(actor.getId());
            simpleActorResponse.setFirstname(actor.getFirstname());
            simpleActorResponse.setLastname(actor.getLastname());
            simpleActorResponse.setHeight(actor.getHeight());
            simpleActorResponseList.add(simpleActorResponse);
        }

        return simpleActorResponseList;
    }
}
