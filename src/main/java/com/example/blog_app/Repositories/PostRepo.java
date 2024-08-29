package com.example.blog_app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_app.Entities.CategoryEntity;
import com.example.blog_app.Entities.PostEntity;
import com.example.blog_app.Entities.UserEntity;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findByUser(UserEntity user);

    List<PostEntity> findByCategory(CategoryEntity category);

    
}
