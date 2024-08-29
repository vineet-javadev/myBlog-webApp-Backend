package com.example.blog_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_app.Entities.CategoryEntity;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity , Integer> {
}
