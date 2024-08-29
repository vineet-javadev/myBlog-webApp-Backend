package com.example.blog_app.ServiceInterface;

import java.util.List;

import com.example.blog_app.Daw.PostDaw;

public interface PostServiceInterface {
    public PostDaw addPost(PostDaw post);

    public PostDaw updatePost(Integer postId , PostDaw post);

    public String deletePost(Integer postId);

    public PostDaw getPost(Integer postId);

    public List<PostDaw> getAllPost();

    public List<PostDaw> getAllPostByUser(Integer userId);

    public List<PostDaw> getAllPostByCategory(Integer categoryId);

    public Integer likeBlogPost(Integer id, Integer userId);
}
