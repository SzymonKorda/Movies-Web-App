package com.example.services;

import com.example.exceptions.ResourceNotFoundException;
import com.example.exceptions.UniqueConstraintException;
import com.example.model.Film;
import com.example.repositories.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Page<Film> findAllFilms(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    @Override
    public Film newFilm(Film film) {
        //musimy "odpakowac" wyjatek i dopiero potem go obsluzyc
        try {
            filmRepository.save(film);
        } catch(RuntimeException e) {
            Throwable rootCause = com.google.common.base.Throwables.getRootCause(e);
            if(rootCause instanceof SQLException) {
                if("23505".equals(((SQLException) rootCause).getSQLState())) {
                    throw new UniqueConstraintException("A film with this title exists in the database", rootCause);
                }
            }
        }
        //nastepnie pobieramy zapisany juz film razem z ID a jezeli go nie ma to zwracamy ten zduplikowany(inaczej sie pluje ze nia ma return)
        Optional<Film> filmOptional = filmRepository.findById(film.getId());
        if(!filmOptional.isPresent()) {
            return filmOptional.get();
        } else {
            return film;
        }
    }

    @Override
    public Film updateFilm(Long filmId, Film filmUpdated) {
        return filmRepository.findById(filmId).map(film -> {
            film.setTitle(filmUpdated.getTitle());
            film.setBoxoffice(filmUpdated.getBoxoffice());
            film.setDuration(filmUpdated.getDuration());
            return filmRepository.save(film);
        }).orElseThrow(() -> new ResourceNotFoundException("Film", "id", filmId));
    }

    @Override
    public void deleteFilmById(Long filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new ResourceNotFoundException("Film", "id", filmId));
        filmRepository.delete(film);
    }

}
