package com.vti.blog_app.specification;

import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.entity.Post;
import com.vti.blog_app.form.CommentFilterForm;
import com.vti.blog_app.form.PostFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;

public class CommentSpecifiation {
    public static Specification<Comment> buildSpec(CommentFilterForm form) {
        return form == null ? null : (root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();
            var search = form.getSearch();
            // WHERE title LIKE "%search%"
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var hasNameLike = builder.like(root.get("name"), pattern);
                var hasEmailLike = builder.like(root.get("email"), pattern);
                var predicate = builder.or(hasNameLike,hasEmailLike);
                predicates.add(predicate);
            }

            var postId = form.getPostId();
            if (postId != null){
                var predicate = builder.equal(root.get("post").get("id"), postId);
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
