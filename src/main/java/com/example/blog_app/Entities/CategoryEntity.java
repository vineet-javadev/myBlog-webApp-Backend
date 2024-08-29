package com.example.blog_app.Entities;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cat_tbl")
public class CategoryEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer catId ;
    @Column(length = 50)
    private String catTitle ;
    @Column(length = 500)
    private String CatDescription ;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<PostEntity> posts = new ArrayList<>();
}