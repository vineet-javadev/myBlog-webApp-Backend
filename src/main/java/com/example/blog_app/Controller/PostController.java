package com.example.blog_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_app.Daw.PostDaw;
import com.example.blog_app.Services.PostService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;
    
    @PostMapping()
    public PostDaw addPost(@RequestBody PostDaw post) {
        return postService.addPost(post);
    }

    @PutMapping("/{postId}")
    public PostDaw updatePost(@PathVariable Integer postId, @RequestBody PostDaw post) {
       return postService.updatePost( postId ,  post);
    }
    
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Integer postId){
        return postService.deletePost(postId);
    }

    @GetMapping("/{postId}")
    public PostDaw getPostDaw(@PathVariable Integer postId) {
        return postService.getPost(postId);
    }

    @GetMapping()
    public List<PostDaw> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("userId/{userId}")
    public List<PostDaw> getAllPostByUser(@PathVariable Integer userId) {
        return postService.getAllPostByUser(userId);
    }

    @GetMapping("catId/{catId}")
    public List<PostDaw> getAllPostByCategory(@PathVariable Integer catId) {
        return postService.getAllPostByCategory(catId);
    }

    @PostMapping("/{id}/like/{userId}")
    public Integer likeBlogPost(@PathVariable Integer id, @PathVariable Integer userId) {
        return postService.likeBlogPost(id, userId);
    }
}
