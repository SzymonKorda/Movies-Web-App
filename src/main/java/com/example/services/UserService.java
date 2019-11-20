package com.example.services;

import com.example.payload.IdRequest;
import com.example.payload.UserProfileResponse;
import com.example.security.CurrentUser;
import com.example.security.UserPrincipal;

public interface UserService {

//    void addFilmToUser(Long filmId, @CurrentUser UserPrincipal currentUser);
    UserProfileResponse findUserById(Long userId);


}
