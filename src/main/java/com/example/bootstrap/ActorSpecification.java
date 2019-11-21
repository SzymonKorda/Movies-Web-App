package com.example.bootstrap;

import com.example.model.Actor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@And({
        @Spec(path = "firstName", spec = Like.class),
        @Spec(path = "lastName", spec = Like.class),
})
public interface ActorSpecification extends Specification<Actor> {

}