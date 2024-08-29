package com.example.blog_app.Daw;

// import java.util.ArrayList;
import java.util.Date;
// import java.util.Set;

import com.example.blog_app.Entities.PostEntity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDaw {
    private Integer postId;
    private String postTitle;
    private String postDescription;
    private String postCategory;
    private String postThumbnail;
    private Date date;
    private int likesCount;

    private Integer catId ;
    private Integer userId;
    
    private CategoryDaw category ;
    private UserDaw user;

    public PostDaw(PostEntity temp){
        postId = temp.getPostId();
        postTitle = temp.getPostTitle();
        postDescription = temp.getPostDescription();
        postCategory = temp.getPostCategory();
        postThumbnail = temp.getPostThumbnail();
        date = temp.getDate();
        likesCount = temp.getLikesCount();

        category = new CategoryDaw(temp.getCategory());
        user = new UserDaw(temp.getUser());

    }

}
