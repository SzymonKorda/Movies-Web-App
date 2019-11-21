package com.example.services;

import com.example.payload.IdRequest;
import com.example.payload.SimpleFilmResponse;
import com.example.payload.UserProfileResponse;
import com.example.security.CurrentUser;
import com.example.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

//    void addFilmToUser(Long filmId, @CurrentUser UserPrincipal currentUser);
    UserProfileResponse findUserById(Long userId);
    Page<SimpleFilmResponse> getUserFilms(Pageable pageable, Long userId);
    void deleteUserFilmById(Long filmId, Long userId);
}
