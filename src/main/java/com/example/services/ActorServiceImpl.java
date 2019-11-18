package com.example.services;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Actor;
import com.example.payload.FullActorResponse;
import com.example.payload.NewActorRequest;
import com.example.payload.SimpleActorResponse;
import com.example.repositories.ActorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor newActor(NewActorRequest newActorRequest) {
        Actor actor = new Actor();
        actor.setFirstName(newActorRequest.getFirstname());
        actor.setLastName(newActorRequest.getLastname());
        actor.setHeight(newActorRequest.getHeight());

        return actorRepository.save(actor);
    }

//    @Override
//    public Page<SimpleActorResponse> getAllActors() {
//
//        List<Actor> actorsList = actorRepository.findAll();
//        List<SimpleActorResponse> simpleActorResponseList = new ArrayList<>();
//
//        for(Actor actor : actorsList) {
//            SimpleActorResponse simpleActorResponse = new SimpleActorResponse();
//            simpleActorResponse.setId(actor.getId());
//            simpleActorResponse.setFirstname(actor.getFirstname());
//            simpleActorResponse.setLastname(actor.getLastname());
//            simpleActorResponse.setHeight(actor.getHeight());
//            simpleActorResponseList.add(simpleActorResponse);
//        }
//
//        return simpleActorResponseList;
//    }


    @Override
    public Page<SimpleActorResponse> getAllActors(Pageable pageable) {

        Page<Actor> actorsListPage = actorRepository.findAll(pageable);
        int totalElements = (int) actorsListPage.getTotalElements();
        return new PageImpl<>(actorsListPage
                .stream()
                .map(person -> new SimpleActorResponse(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getHeight()))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    @Override
    public FullActorResponse findActorById(Long actorId) {
        Actor actor = actorRepository.findById(actorId).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", actorId));
        FullActorResponse fullActorResponse = new FullActorResponse();

        fullActorResponse.setId(actor.getId());
        fullActorResponse.setFirstName(actor.getFirstName());
        fullActorResponse.setLastName(actor.getLastName());
        fullActorResponse.setHeight(actor.getHeight());
        fullActorResponse.setDescription(actor.getDescription());
        fullActorResponse.setBornYear(actor.getBornYear());
        fullActorResponse.setBornPlace(actor.getBornPlace());

        return fullActorResponse;
    }
}
