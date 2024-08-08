package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentUpdateFrom;

public class CommentMapper {
    public static Comment map(CommentCreateFrom form) {
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto.withSelfRel();
    }

    public static void map(CommentUpdateFrom form, Comment comment){
        comment.setBody(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
    }
}
