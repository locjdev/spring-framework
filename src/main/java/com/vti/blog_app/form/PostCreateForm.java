package com.vti.blog_app.form;

import com.vti.blog_app.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateForm {
    private String title;
    private String content;
    private String description;
    private Post.Status status;
}
