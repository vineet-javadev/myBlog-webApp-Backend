package com.example.blog_app.Daw;


// import java.sql.Blob;
import java.sql.Date;

import com.example.blog_app.Entities.UserEntity;

// import jakarta.persistence.Lob;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDaw {
    private Integer userId;
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
    private String userBio;
    private String userProfilePic;
    private String userCoverPicture;
    private String LinkedInURL;
    private String GitHubURL;
    private String FacebookURL;
    private String YoutubeURL;
    

    public UserDaw(UserEntity userEntity) {
        userId = userEntity.getUserId();
        emailId = userEntity.getEmailId();
        // password = userEntity.getPassword();
        password = "************";

        userName = userEntity.getUserName();
        userLastName = userEntity.getUserLastName();
        userGender = userEntity.getUserGender();
        userLocation = userEntity.getUserLocation();
        userContact = userEntity.getUserContact();
        userWebsite = userEntity.getUserWebsite();
        userDOB = userEntity.getUserDOB();
        userNationality = userEntity.getUserNationality();
        userBio = userEntity.getUserBio();
        userProfilePic = userEntity.getUserProfilePic();
        userCoverPicture = userEntity.getUserCoverPicture();
        LinkedInURL = userEntity.getLinkedInURL();
        GitHubURL = userEntity.getGitHubURL();
        FacebookURL = userEntity.getFacebookURL();
        YoutubeURL = userEntity.getYoutubeURL();
    }
}
