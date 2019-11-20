package com.example.controllers;

import com.example.exceptions.ResourceNotFoundException;
import com.example.model.User;
import com.example.payload.ApiResponse;
import com.example.payload.IdRequest;
import com.example.payload.SimpleFilmResponse;
import com.example.payload.UserProfileResponse;
import com.example.repositories.UserRepository;
import com.example.services.FilmService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class UserController {

    private FilmService filmService;
    private UserService userService;

    public UserController(FilmService filmService, UserService userService) {
        this.filmService = filmService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}")
    @RolesAllowed("ROLE_USER")
    public UserProfileResponse getUserProfile(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/users/{userId}/films")
    @RolesAllowed("ROLE_USER")
    public SimpleFilmResponse getUserProfile(@PathVariable Long userId) {
        return userService.getUserFilms(userId);
    }
//      ulubione
//    /films/id/favourites

//    @PostMapping("films/{filmId}/favourites")
//    @RolesAllowed("ROLE_USER")
//    public



//    @PostMapping("/users/{userId}/films")
//    @RolesAllowed("ROLE_USER")
//    public ResponseEntity<?> addFilmToUser(@PathVariable Long , @Valid @RequestBody IdRequest idRequest) {
//        userService.addFilmToUser(userId, idRequest);
//        return ResponseEntity.ok(new ApiResponse(true, "Film added to User successfully"));
//    }


///films/{id}/favourites

}
