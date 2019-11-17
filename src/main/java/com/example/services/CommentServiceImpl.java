package com.example.services;

import com.example.model.Comment;
import com.example.model.Film;
import com.example.payload.CommentResponse;
import com.example.payload.NewCommentRequest;
import com.example.payload.SimpleFilmResponse;
import com.example.repositories.CommentRepository;
import com.example.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<CommentResponse> getByFilmId(Pageable pageable, Long filmId) {
       Page<Comment> commentList = commentRepository.findByFilmId(pageable, filmId);
        int totalElements = (int) commentList.getTotalElements();

        return new PageImpl<>(commentList
                .stream()
                .map(comment -> new CommentResponse(
                        comment.getId(),
                        comment.getUser().getUsername(),
                        comment.getContent()))
                .collect(Collectors.toList()), pageable, totalElements);

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
