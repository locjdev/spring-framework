package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentUpdateFrom;

public class CommentMapper {
    public static Comment map(CommentCreateFrom form) {
        var comment = new Comment();
        var pk = new Comment.PrimaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setPk(comment.getPk());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }

    public static void map(CommentUpdateFrom form, Comment comment){
        var pk = new Comment.PrimaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setPk(pk);
        comment.setBody(form.getBody());
    }
}
