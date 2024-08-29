package com.example.blog_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_app.Entities.UserEntity;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<UserEntity , Integer>{
    List<UserEntity> findByEmailId(String emailId);
}
