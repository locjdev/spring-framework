package com.vti.blog_app.converter;

import com.vti.blog_app.entity.Post;
import jakarta.persistence.AttributeConverter;

public class PostStatusConverter implements AttributeConverter<Post.Status, Character> {

    @Override
    public Character convertToDatabaseColumn(Post.Status status) {
        return status.toString().charAt(0);
    }

    @Override
    public Post.Status convertToEntityAttribute(Character code) {
        if (code == 'O') return Post.Status.OPENING;
        if (code == 'C') return Post.Status.CLOSED;
        throw new IllegalStateException(code.toString());
    }
}
