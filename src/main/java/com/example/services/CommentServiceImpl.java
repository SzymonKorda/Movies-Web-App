package com.example.services;

import com.example.model.Comment;
import com.example.payload.NewCommentRequest;
import com.example.repositories.CommentRepository;
import com.example.security.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

//    @Override
//    public Comment newComment(Long filmId, UserPrincipal currentUser, NewCommentRequest newCommentRequest) {
//        Comment comment = new Comment();
//        comment.setFilmId(newCommentRequest.getFilmId());
//        comment.setUserId(currentUser.getId());
//        comment.setContent(newCommentRequest.getContent());
//
//        commentRepository.save(comment);
//    }
}
