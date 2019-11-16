package com.example.repositories;

import com.example.model.Film;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
//    Optional<Film> findByTitle(String title);
}
