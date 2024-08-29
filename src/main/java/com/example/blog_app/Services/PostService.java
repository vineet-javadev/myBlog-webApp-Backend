package com.example.blog_app.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.Daw.CategoryDaw;
import com.example.blog_app.Daw.PostDaw;
import com.example.blog_app.Daw.UserDaw;
import com.example.blog_app.Entities.CategoryEntity;
import com.example.blog_app.Entities.PostEntity;
import com.example.blog_app.Entities.UserEntity;
import com.example.blog_app.Repositories.CategoryRepo;
import com.example.blog_app.Repositories.PostRepo;
import com.example.blog_app.Repositories.UserRepo;
import com.example.blog_app.ServiceInterface.PostServiceInterface;

import jakarta.persistence.NoResultException;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDaw addPost(PostDaw post) {
        try {

            UserEntity userEntity = userRepo.findById(post.getUserId()).orElseThrow();
            CategoryEntity categoryEntity = categoryRepo.findById(post.getCatId()).orElseThrow();

            PostEntity temp = new PostEntity();

            temp.setPostTitle(post.getPostTitle());
            temp.setPostDescription(post.getPostDescription());
            temp.setPostCategory(categoryEntity.getCatTitle());
            // temp.setPostThumbnail(post.getPostThumbnail());
            temp.setPostThumbnail(null);
            temp.setDate(new Date());
            temp.setLikesCount(0);

            temp.setCategory(categoryEntity);
            temp.setUser(userEntity);

            return new PostDaw(postRepo.save(temp));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public PostDaw updatePost(Integer postId, PostDaw post) {
        try {
            UserEntity userEntity = userRepo.findById(post.getUserId()).orElseThrow();
            CategoryEntity categoryEntity = categoryRepo.findById(post.getCatId()).orElseThrow();

            PostEntity temp = postRepo.findById(postId).orElseThrow();
            temp.setPostTitle(post.getPostTitle());
            temp.setPostDescription(post.getPostDescription());
            temp.setPostCategory(post.getPostCategory());
            temp.setPostThumbnail(post.getPostThumbnail());
            temp.setDate(post.getDate());

            temp.setCategory(categoryEntity);
            temp.setUser(userEntity);

            return new PostDaw(postRepo.save(temp));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String deletePost(Integer postId) {
        try {
            postRepo.deleteById(postId);
            return "Post deleted successfully";
        } catch (Exception e) {
            System.out.println(e);
            return "Post not found";
        }
    }

    @Override
    public PostDaw getPost(Integer postId) {
        try {
            PostEntity temp = postRepo.findById(postId).orElseThrow();

            CategoryDaw categoryDaw = new CategoryDaw(temp.getCategory());
            UserDaw userDaw = new UserDaw(temp.getUser());

            PostDaw result = new PostDaw();
            result.setPostId(temp.getPostId());
            result.setPostTitle(temp.getPostTitle());
            result.setPostDescription(temp.getPostDescription());
            result.setPostCategory(temp.getPostCategory());
            result.setPostThumbnail(temp.getPostThumbnail());
            result.setDate(temp.getDate());
            result.setUserId(temp.getUser().getUserId());
            result.setCatId(temp.getCategory().getCatId());
            result.setLikesCount(temp.getLikesCount());
            result.setCategory(categoryDaw);
            result.setUser(userDaw);

            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<PostDaw> getAllPost() {
        try {
            List<PostDaw> result = new ArrayList<>();
            List<PostEntity> data = postRepo.findAll();

            // for (PostEntity elemEntity : postRepo.findAll()) {
            for(int i = data.size()-1 ; i >= 0 ; i--){

                PostEntity elemEntity = data.get(i);
                CategoryDaw categoryDaw = new CategoryDaw(elemEntity.getCategory());
                UserDaw userDaw = new UserDaw(elemEntity.getUser());

                PostDaw temp = new PostDaw();
                temp.setPostId(elemEntity.getPostId());
                temp.setPostTitle(elemEntity.getPostTitle());
                temp.setPostDescription(elemEntity.getPostDescription());
                temp.setPostCategory(elemEntity.getPostCategory());
                temp.setPostThumbnail(elemEntity.getPostThumbnail());
                temp.setDate(elemEntity.getDate());
                temp.setLikesCount(elemEntity.getLikesCount());
                temp.setUserId(elemEntity.getUser().getUserId());
                temp.setCatId(elemEntity.getCategory().getCatId());
                temp.setCategory(categoryDaw);
                temp.setUser(userDaw);

                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<PostDaw> getAllPostByUser(Integer userId) {
        try {
            UserEntity userEntity = userRepo.findById(userId).orElseThrow();

            List<PostEntity> postEntities = postRepo.findByUser(userEntity);
            List<PostDaw> result = new ArrayList<>();

            for (PostEntity elemEntity : postEntities) {
                PostDaw temp = new PostDaw();
                temp.setPostId(elemEntity.getPostId());
                temp.setPostTitle(elemEntity.getPostTitle());
                temp.setPostDescription(elemEntity.getPostDescription());
                temp.setPostCategory(elemEntity.getPostCategory());
                temp.setPostThumbnail(elemEntity.getPostThumbnail());
                temp.setDate(elemEntity.getDate());
                temp.setLikesCount(elemEntity.getLikesCount());
                temp.setCategory(new CategoryDaw(elemEntity.getCategory()));
                temp.setUser(new UserDaw(elemEntity.getUser()));

                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<PostDaw> getAllPostByCategory(Integer categoryId) {
        try {
            CategoryEntity categoryEntity = categoryRepo.findById(categoryId).orElseThrow();

            List<PostEntity> postEntities = postRepo.findByCategory(categoryEntity);
            List<PostDaw> result = new ArrayList<>();

            for (PostEntity elemEntity : postEntities) {
                PostDaw temp = new PostDaw();
                temp.setPostId(elemEntity.getPostId());
                temp.setPostTitle(elemEntity.getPostTitle());
                temp.setPostDescription(elemEntity.getPostDescription());
                temp.setPostCategory(elemEntity.getPostCategory());
                temp.setLikesCount(elemEntity.getLikesCount());
                temp.setPostThumbnail(elemEntity.getPostThumbnail());
                temp.setDate(elemEntity.getDate());
                temp.setLikesCount(elemEntity.getLikesCount());
                temp.setCategory(new CategoryDaw(elemEntity.getCategory()));
                temp.setUser(new UserDaw(elemEntity.getUser()));

                result.add(temp);
            }
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer likeBlogPost(Integer id, Integer userId) {
        PostEntity post = postRepo.findById(id).orElseThrow(NoResultException::new);
        UserEntity user = userRepo.findById(userId).orElseThrow(NoResultException::new);
        if (!post.getUsersWhoLiked().contains(user)) {
            post.getUsersWhoLiked().add(user);
            post.setLikesCount(post.getLikesCount() + 1);
            postRepo.save(post);
            return post.getLikesCount();
        }else{
            post.getUsersWhoLiked().remove(user);
            post.setLikesCount(post.getLikesCount() - 1);
            postRepo.save(post);
            return post.getLikesCount();
        }
    } 
}