package com.vti.blog_app.repository;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Comment.PrimaryKey> {
    // VD: Lấy ra tất cả comment theo post id
    Page<Comment> findByPostId(Long postId, Pageable pageable);


}
