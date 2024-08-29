package com.example.blog_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_app.Daw.CategoryDaw;
import com.example.blog_app.Services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin("*")
@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping()
    public CategoryDaw createCategory(@RequestBody CategoryDaw data) {
        System.out.println(data);
        return categoryService.CreateCategory(data);
    }
    
    @DeleteMapping("/{catId}")
    public void CategoryDelete(@PathVariable Integer catId){
        categoryService.deleteCategory(catId);
    }

    @GetMapping()
    public List<CategoryDaw> getAll() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{catId}")
    public CategoryDaw getOne(@PathVariable Integer catId){
        return categoryService.getOneCategory(catId);
    }
    @PutMapping("/{catId}")
    public CategoryDaw UpdateCategory(@PathVariable Integer catId , @RequestBody CategoryDaw data){
        return categoryService.UpdateCategory(catId , data);
    }
}
