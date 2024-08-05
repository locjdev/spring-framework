package com.vti.blog_app.entity;

import com.vti.blog_app.converter.PostStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

// hibernate => k can tao database, no se tu tao
@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    //Auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Neu truyen bai viet khong co id (=null) => tao moi (update neu co id)
    // Kieu du lieu nguyen thuy khong the truyen null => xai null
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 150, nullable = false)
    private String content;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
//    @Enumerated(value = EnumType.STRING)
    @Convert(converter = PostStatusConverter.class)
    private Status status;


    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "update_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToOne(mappedBy = "post")
    private Comment comment;


    public enum Status {
        OPENING, CLOSED
    }
}
