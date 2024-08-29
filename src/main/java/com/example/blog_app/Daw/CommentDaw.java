package com.example.blog_app.Daw;

import java.util.Date;

import com.example.blog_app.Entities.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDaw {
    private Integer commentId;
    private String commentContent;
    private Date commentDate;
    private UserDaw user;
    private Integer postId;
    private PostDaw post;

    public CommentDaw( CommentEntity entity){
        this.commentId = entity.getCommentId();
        this.commentContent = entity.getCommentContent();
        this.commentDate = entity.getCommentDate();
        this.user = new UserDaw(entity.getUser());
        this.post = new PostDaw(entity.getPost());
    }
}
