package com.example.blog_app.ServiceInterface;

import java.util.List;

import com.example.blog_app.Daw.CommentDaw;

public interface CommentServiceInterface {
    public CommentDaw addComment(Integer postId , Integer userId , CommentDaw comment);

    public CommentDaw getOneComment(Integer commentId);

    public List<CommentDaw> getAllComment();

    public List<CommentDaw> getAllCommentByPost( Integer postId);

    public String deleteOneComment(Integer commentId);

    public CommentDaw updateComment(Integer commentId , CommentDaw data);
}
