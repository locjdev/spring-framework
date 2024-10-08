package com.vti.blog_app.controller;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentFilterForm;
import com.vti.blog_app.form.CommentUpdateFrom;
import com.vti.blog_app.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        return commentService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(@PathVariable("postId") Long postId, Pageable pageable){
        return commentService.findByPostId(postId,pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(@PathVariable("postId") Long postId,
                             @RequestBody CommentCreateFrom form) {
        return commentService.create(postId, form);
    }

    @PutMapping("/api/v1/comments/{id}")
    public CommentDto update(@PathVariable("id") Long id,
                             @RequestBody CommentUpdateFrom form) {
        return commentService.update(id, form);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(Long id){
        commentService.deleteById(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String email){
        commentService.deleteByEmail(email);
    }
}
