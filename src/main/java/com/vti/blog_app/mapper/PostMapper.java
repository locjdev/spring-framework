package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.entity.Post;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostUpdateForm;

public class PostMapper {
    public static Post map(PostCreateForm form) {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setStatus((form.getStatus()));
        return post;
    }

    public static PostDto map(Post post) {
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setStatus((post.getStatus()));
        dto.setCreateAt(post.getCreateAt());
        dto.setUpdateAt(post.getUpdateAt());
        return dto;
    }

    public static void map(PostUpdateForm form, Post post) {
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setStatus((form.getStatus()));
    }
}
