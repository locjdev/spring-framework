package com.vti.blog_app.form;

import com.vti.blog_app.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateForm {
    private String title;
    private String content;
    private String description;
    private Post.Status status;
}
