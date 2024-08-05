package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.PostComment;
import com.vti.blog_app.form.CommentCreateFrom;
import com.vti.blog_app.form.CommentUpdateFrom;
import com.vti.blog_app.mapper.CommentMapper;
import com.vti.blog_app.repository.CommentRepository;
import com.vti.blog_app.repository.PostCommentRepository;
import com.vti.blog_app.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private PostCommentRepository postCommentRepository;

    @Override
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable).map(CommentMapper::map);
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
//        return commentRepository.findByPostId(postId, pageable).map(CommentMapper::map);
    return Page.empty();
    }

    @Override
    public CommentDto findById(Long id) {
        return commentRepository.findById(id).map(CommentMapper::map).orElse(null);

    }

    @Override
    public CommentDto create(Long postId, CommentCreateFrom form) {
        var optional = postRepository.findById(postId);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        var comment = CommentMapper.map(form);
        var savedComment = commentRepository.save(comment);
        var postComment = new PostComment();
        postComment.setPost(post);
        postComment.setComment(savedComment);
        postCommentRepository.save(postComment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public CommentDto update(Long id, CommentUpdateFrom form) {
        var optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var comment = optional.get();
        CommentMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    // Nếu có lỗi xảy ra sẽ roll back
    @Transactional
    public void deleteByEmail(String email){
        commentRepository.deleteByEmail(email);
    }
}
