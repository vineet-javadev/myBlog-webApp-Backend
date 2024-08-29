package com.example.blog_app.Entities;

import java.sql.Date;
import java.util.ArrayList;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(length = 50)
    private String emailId;
    private String password;

    private String userName;
    private String userLastName;
    private String userGender;
    private String userLocation;
    private String userContact;
    private String userWebsite;
    private Date userDOB;
    private String userNationality;
    @Column(length = 500)
    private String userBio;
    private String userProfilePic;
    private String userCoverPicture;
    private String linkedInURL;
    private String gitHubURL;
    private String facebookURL;
    private String youtubeURL;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<PostEntity> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new ArrayList<>();

     @ManyToMany
    @JoinTable(
        name = "user_friends",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<UserEntity> friends = new HashSet<>();

    @ManyToMany(mappedBy = "usersWhoLiked")
    private Set<PostEntity> likedPosts = new HashSet<>();

}
