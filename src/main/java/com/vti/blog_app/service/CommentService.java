package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentUpdateFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(Long postId, CommentCreateFrom form);

    CommentDto update(Long id, CommentUpdateFrom form);

    void deleteById(Long id);

    void deleteByEmail(String email);
}
