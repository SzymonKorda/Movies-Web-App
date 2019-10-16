package com.example.services;

import com.example.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmService {

//    Film findById(Long filmId);
    Page<Film> findAllFilms(Pageable pageable);
    Film newFilm(Film film);
    Film updateFilm(Long filmId, Film filmUpdated);
    void deleteFilmById(Long filmId);

}
