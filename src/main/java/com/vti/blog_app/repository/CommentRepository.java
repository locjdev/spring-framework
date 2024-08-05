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

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 1. Method name
    // Tiền tố: findBy, existsBy, countBy, deleteBy
    // VD1: lấy ra tất cả comment theo name
    List<Comment> findByName(String name);
    // VD2: Lấy ra tất cả comment có body chứa "search"
    List<Comment> findByBodyContaining(String search);
    // VD3: Lấy ra tất cả comment theo name hoặc email
    List<Comment> findByNameOrEmail(String name, String email);
    // VD: Lấy ra tất cả comment theo post id
//    Page<Comment> findByPostId(Long postId, Pageable pageable);

    // 2.@Query có 3 cách
    @Query("DELETE FROM Comment WHERE email= :email")
    // Sửa dữ liệu
    @Modifying
    void deleteByEmail(@Param("email") String email);

    // Sửa dữ liệu
    @Modifying
    @Query("DELETE FROM Comment WHERE name = ?1 AND email = ?2")
    void deleteByNam(String name, String email);

    @Query(value = "SELECT * FROM comment WHERE id > ?1", nativeQuery = true)
    Page<CommentDto> findByIdGreaterThan(Long id, Pageable pageable);
}
