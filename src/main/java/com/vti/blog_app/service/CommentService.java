package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentUpdateFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Comment.PrimaryKey id);

    CommentDto create(Long postId, CommentCreateFrom form);

    CommentDto update(Comment.PrimaryKey id, CommentUpdateFrom form);

    void deleteById(Comment.PrimaryKey id);

    void deleteByEmail(String email);
}
