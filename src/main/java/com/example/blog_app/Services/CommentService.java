package com.example.blog_app.Services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.Daw.CommentDaw;
import com.example.blog_app.Entities.CommentEntity;
import com.example.blog_app.Entities.PostEntity;
import com.example.blog_app.Entities.UserEntity;
import com.example.blog_app.Repositories.CommentRepo;
import com.example.blog_app.Repositories.PostRepo;
import com.example.blog_app.Repositories.UserRepo;
import com.example.blog_app.ServiceInterface.CommentServiceInterface;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public CommentDaw addComment(Integer postId, Integer userId, CommentDaw comment) {
        try {
            PostEntity postEntity = postRepo.findById(postId).orElseThrow();
            UserEntity userEntity = userRepo.findById(userId).orElseThrow();
            CommentEntity commentEntity = new CommentEntity();

            commentEntity.setCommentContent(comment.getCommentContent());
            commentEntity.setCommentDate(new Date());
            commentEntity.setUser(userEntity);
            commentEntity.setPost(postEntity);
            return new CommentDaw(commentRepo.save(commentEntity));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public CommentDaw getOneComment(Integer commentId) {
        try {
            CommentEntity commentEntity = commentRepo.findById(commentId).orElseThrow();
            return new CommentDaw(commentEntity);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<CommentDaw> getAllComment() {
        try {
            return commentRepo.findAll().stream().map(CommentDaw::new).toList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String deleteOneComment(Integer commentId) {
        try {
            commentRepo.deleteById(commentId);
            return "Comment Deleted";
        } catch (Exception e) {
            System.out.println(e);
            return "Comment not exist";
        }
    }

    @Override
    public CommentDaw updateComment(Integer commentId, CommentDaw data) {
        try {
            CommentEntity commentEntity = commentRepo.findById(commentId).orElseThrow();
            CommentEntity temp = new CommentEntity();

            temp.setCommentId(commentEntity.getCommentId());
            temp.setCommentContent(data.getCommentContent());
            temp.setCommentDate(commentEntity.getCommentDate());
            temp.setUser(commentEntity.getUser());
            temp.setPost(commentEntity.getPost());
            return new CommentDaw(commentRepo.save(temp));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<CommentDaw> getAllCommentByPost(Integer postId) {
        System.out.println(postId);
        try {
            PostEntity postEntity = postRepo.findById(postId).orElseThrow();
            try {
                return commentRepo.findByPost(postEntity).stream().map(CommentDaw::new).toList();
            } catch (Exception e) {
                System.out.println("Exception : ");
                System.out.println(e);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Post Id is wrong");
            System.out.println(e);
            return null;

        }
    }

}
