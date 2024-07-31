package com.vti.blog_app.service;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    // Phân trang
    Page<PostDto> findAll(Pageable pageable);
    PostDto findById(Long id);
    PostDto create(PostCreateForm form);
    PostDto update(Long id, PostUpdateForm form);
    void deleteById(Long id);
}
