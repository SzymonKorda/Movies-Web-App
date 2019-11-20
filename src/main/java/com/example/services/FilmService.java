package com.example.services;

import com.example.model.Film;
import com.example.payload.*;
import com.example.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {

//    Film findById(Long filmId);
    Page<SimpleFilmResponse> findAllFilms(Pageable pageable);
//    List<SimpleFilmResponse> findAllFilms();
    void newFilm(NewFilmRequest newFilmRequest);
    Film updateFilm(Long filmId, FilmUpdateRequest filmUpdateRequest);
    void deleteFilmById(Long filmId);
    FullFilmResponse findFilmById(Long filmId);
    void addActorToFilm(Long filmId, IdRequest idRequest);
    void addCommentToFilm(UserPrincipal currentUser, Long filmId, NewCommentRequest newCommentRequest);
    void addFilmToUser(UserPrincipal currentUser, Long filmId);
    Page<SimpleFilmResponse> getByActorId(Pageable pageable, Long actorId);

}
