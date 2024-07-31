package com.vti.blog_app.dto;

import com.vti.blog_app.entity.Post;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Post.Status status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
