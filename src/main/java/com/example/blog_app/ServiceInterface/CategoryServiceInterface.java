package com.example.blog_app.ServiceInterface;

import java.util.List;

import com.example.blog_app.Daw.CategoryDaw;

public interface CategoryServiceInterface {
    public CategoryDaw CreateCategory(CategoryDaw data);

    public String deleteCategory(Integer catId);

    public List<CategoryDaw> getAllCategory();

    public CategoryDaw getOneCategory(Integer catId);

    public CategoryDaw UpdateCategory(Integer catId , CategoryDaw data);
}
