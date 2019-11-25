package com.example.specification;

import com.example.model.Film;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@Or({
        @Spec(path = "title", params = "search", spec = LikeIgnoreCase.class),
})

public interface FilmSpecification extends Specification<Film> {
}
