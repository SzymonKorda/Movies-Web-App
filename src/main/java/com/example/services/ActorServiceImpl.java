package com.example.services;

import com.example.model.Actor;
import com.example.payload.NewActorRequest;
import com.example.repositories.ActorRepository;
import org.springframework.stereotype.Service;

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
}
