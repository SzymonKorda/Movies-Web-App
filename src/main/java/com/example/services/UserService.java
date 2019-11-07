package com.example.services;

import com.example.payload.IdRequest;

public interface UserService {

    void addFilmToActor(Long filmId, IdRequest idRequest);

}
