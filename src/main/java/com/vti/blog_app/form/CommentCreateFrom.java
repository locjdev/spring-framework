package com.vti.blog_app.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateFrom {
    private String name;
    private String email;
    private String body;
}
