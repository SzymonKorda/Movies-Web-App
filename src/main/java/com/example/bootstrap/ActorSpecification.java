package com.example.bootstrap;

import com.example.model.Actor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@Or({
//        @Spec(path = "firstName", params = "search", spec = LikeIgnoreCase.class),
        @Spec(path = "lastName", params = "search", spec = LikeIgnoreCase.class),
})
public interface ActorSpecification extends Specification<Actor> {

}