package com.example.blog_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_app.Daw.CommentDaw;
import com.example.blog_app.Services.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{postId}/user/{userId}")
    public CommentDaw addComment(@PathVariable Integer postId , @PathVariable Integer  userId , @RequestBody CommentDaw commentDaw) {
        return commentService.addComment(postId , userId , commentDaw);
    }

    @GetMapping("/{commentId}")
    public CommentDaw getOneComment(@PathVariable Integer commentId) {
        return commentService.getOneComment(commentId);
    }

    @GetMapping()
    public List<CommentDaw> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/postId/{pId}")
    public List<CommentDaw> getAllCommentByPost(@PathVariable Integer pId) {
        return commentService.getAllCommentByPost(pId);
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteOneComment(commentId);
    }

    @PutMapping("/{commentId}")
    public CommentDaw updateComment(@PathVariable Integer commentId, @RequestBody CommentDaw data) {
        return commentService.updateComment(commentId, data);
    }
}
