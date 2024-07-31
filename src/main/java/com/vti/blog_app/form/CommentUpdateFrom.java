package com.vti.blog_app.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateFrom {
    private String name;
    private String email;
    private String body;
}
