package com.example.controllers;

import com.example.payload.ApiResponse;
import com.example.payload.FilmUpdateRequest;
import com.example.repositories.CommentRepository;
import com.example.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @DeleteMapping("/comments/{commentId}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok(new ApiResponse(true, "Comment deleted successfully"));
    }
}
