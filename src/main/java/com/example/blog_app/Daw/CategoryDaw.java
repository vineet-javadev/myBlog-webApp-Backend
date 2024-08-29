package com.example.blog_app.Daw;


import com.example.blog_app.Entities.CategoryEntity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDaw {
    private Integer catId ;
    private String catTitle ;
    private String catDescription ;

    public CategoryDaw(CategoryEntity categoryEntity) {
        catId = categoryEntity.getCatId();
        catTitle = categoryEntity.getCatTitle();
        catDescription = categoryEntity.getCatDescription();
    }
}
