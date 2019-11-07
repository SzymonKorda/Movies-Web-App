package com.example.services;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.Film;
import com.example.model.User;
import com.example.payload.IdRequest;
import com.example.repositories.FilmRepository;
import com.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private FilmRepository filmRepository;

    public UserServiceImpl(UserRepository userRepository, FilmRepository filmRepository) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    @Transactional
    public void addFilmToActor(Long userId, IdRequest idRequest) {
        Film film = filmRepository.findById(idRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Film", "id", idRequest.getId()));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.getUserFilms().add(film);
        film.getUsers().add(user);
    }
}
