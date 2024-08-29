package com.example.blog_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_app.Entities.CommentEntity;
import com.example.blog_app.Entities.PostEntity;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<CommentEntity , Integer> {

    List<CommentEntity> findByPost(PostEntity post);
}
