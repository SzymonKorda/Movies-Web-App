package com.example.services;

import com.example.model.Film;
import com.example.payload.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {

//    Film findById(Long filmId);
//    Page<Film> findAllFilms(Pageable pageable);
    List<SimpleFilmResponse> findAllFilms();
    Film newFilm(NewFilmRequest newFilmRequest);
    Film updateFilm(Long filmId, FilmUpdateRequest filmUpdateRequest);
    void deleteFilmById(Long filmId);
    FullFilmResponse findFilmById(Long filmId);
    void addActorToFilm(Long filmId, IdRequest idRequest);

}
