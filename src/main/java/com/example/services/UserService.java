package com.example.services;

import com.example.payload.IdRequest;
import com.example.payload.UserProfileResponse;

public interface UserService {

    void addFilmToActor(Long filmId, IdRequest idRequest);
    UserProfileResponse findUserById(Long userId);

}
