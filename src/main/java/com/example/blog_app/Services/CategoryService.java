package com.example.blog_app.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.Daw.CategoryDaw;
import com.example.blog_app.Entities.CategoryEntity;
import com.example.blog_app.Repositories.CategoryRepo;
import com.example.blog_app.ServiceInterface.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDaw CreateCategory(CategoryDaw data) {
        try {
            CategoryEntity temp = new CategoryEntity();

            temp.setCatTitle(data.getCatTitle());
            temp.setCatDescription(data.getCatDescription());
            return new CategoryDaw(categoryRepo.save(temp));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String deleteCategory(Integer catId) {
        try {
            categoryRepo.deleteById(catId);
            return "Category deleted Successfully";
        } catch (Exception e) {
            System.out.println(e);
            return "Unable to find this Category";
        }
    }

    @Override
    public List<CategoryDaw> getAllCategory() {
        try {
            List<CategoryDaw> list = new ArrayList<>();
            for (CategoryEntity elemEntity : categoryRepo.findAll()) {
                CategoryDaw temp = new CategoryDaw(elemEntity);
                list.add(temp);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public CategoryDaw UpdateCategory(Integer catId, CategoryDaw data) {
        try {
            CategoryEntity categoryEntity = categoryRepo.findById(catId).orElseThrow();

            categoryEntity.setCatTitle(data.getCatTitle());
            categoryEntity.setCatDescription(data.getCatDescription());

            return new CategoryDaw(categoryRepo.save(categoryEntity));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public CategoryDaw getOneCategory(Integer catId) {
        try{
        return new CategoryDaw(categoryRepo.findById(catId).orElseThrow());
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
    }

}
