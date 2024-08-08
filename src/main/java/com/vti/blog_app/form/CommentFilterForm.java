package com.vti.blog_app.form;

import com.vti.blog_app.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentFilterForm {
    private String search;
    private Long postId;
}
