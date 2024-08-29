package com.example.blog_app.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_tbl")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(length = 50)
    private String postTitle;
    @Column(length = 5000)
    private String postDescription;
    private List<Integer> likeUserId;

    private String postCategory;
    private Date date;
    private String postThumbnail;

    // private Integer userId;

    @JoinColumn(name = "fk_cat_id")
    @ManyToOne
    private CategoryEntity category ;
    @JoinColumn(name = "fk_user_id")
    @ManyToOne
    private UserEntity user;
    
    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new ArrayList<>();
    
    private int likesCount;

    @ManyToMany
    @JoinTable(
        name = "post_users",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> usersWhoLiked = new HashSet<>();

}
