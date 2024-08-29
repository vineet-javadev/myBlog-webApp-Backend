package com.example.blog_app.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.Daw.PostDaw;
import com.example.blog_app.Daw.UserDaw;
import com.example.blog_app.Entities.UserEntity;
import com.example.blog_app.Repositories.UserRepo;
import com.example.blog_app.ServiceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepo repo;

    @Override
    public List<UserDaw> getAllUsers() {
        List<UserDaw> lst = new ArrayList<UserDaw>();

        try {
            for (UserEntity elemEntity : repo.findAll()) {
                UserDaw temp = new UserDaw(elemEntity);
                lst.add(temp);
            }
            return lst;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public String getUserPass(Integer userId) {
        try {
            Optional<UserEntity> dbData = repo.findById(userId);

            return dbData.get().getPassword();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public UserDaw getUserDetails(Integer userId) {

        try {
            UserEntity dbData = repo.findById(userId).orElseThrow();
            return new UserDaw(dbData);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public UserDaw postData(UserDaw obj) {

        try {
            UserEntity entity = new UserEntity();

            entity.setEmailId(obj.getEmailId());
            entity.setPassword(obj.getPassword());

            entity.setUserName(obj.getUserName());
            entity.setUserLastName(obj.getUserLastName());
            entity.setUserDOB(obj.getUserDOB());
            entity.setUserBio(obj.getUserBio());
            entity.setUserNationality(obj.getUserNationality());
            entity.setUserGender(obj.getUserGender());
            entity.setUserLocation(obj.getUserLocation());
            entity.setUserContact(obj.getUserContact());
            entity.setUserWebsite(obj.getUserWebsite());
            entity.setUserProfilePic(obj.getUserProfilePic());
            entity.setUserCoverPicture(obj.getUserCoverPicture());
            entity.setLinkedInURL(obj.getLinkedInURL());
            entity.setGitHubURL(obj.getGitHubURL());
            entity.setYoutubeURL(obj.getYoutubeURL());
            entity.setFacebookURL(obj.getFacebookURL());

            return new UserDaw(repo.save(entity));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public UserDaw UpdateUser(Integer userId, String pass, UserDaw obj) {
        try {
            UserEntity entity = new UserEntity();
            UserEntity dbData = repo.findById(userId).orElseThrow();
            if(!dbData.getPassword().equals(pass)){
                return  null;
            }
            entity.setUserId(userId);

            if (obj.getEmailId() != null && obj.getEmailId() != "") {
                entity.setEmailId(obj.getEmailId());
            } else {
                entity.setEmailId(dbData.getEmailId());
            }

            if (obj.getPassword() != null && obj.getPassword() != "") {
                entity.setPassword(obj.getPassword());
            } else {
                entity.setPassword(dbData.getPassword());
            }

            if (obj.getUserName() != null && obj.getUserName() !="") {
                entity.setUserName(obj.getUserName());
            } else {
                entity.setUserName(dbData.getUserName());
            }

            if (obj.getUserLastName() != null && obj.getUserLastName() != "") {
                entity.setUserLastName(obj.getUserLastName());
            } else {
                entity.setUserLastName(dbData.getUserLastName());
            }

            if (obj.getUserDOB() != null) {
                entity.setUserDOB(obj.getUserDOB());
            } else {
                entity.setUserDOB(dbData.getUserDOB());
            }

            if (obj.getUserBio() != null && obj.getUserBio() != "") {
                entity.setUserBio(obj.getUserBio());
            } else {
                entity.setUserBio(dbData.getUserBio());
            }

            if (obj.getUserNationality() != null && obj.getUserNationality() != "") {
                entity.setUserNationality(obj.getUserNationality());
            } else {
                entity.setUserNationality(dbData.getUserNationality());
            }

            if (obj.getUserGender() != null && obj.getUserGender() != "") {
                entity.setUserGender(obj.getUserGender());
            } else {
                entity.setUserGender(dbData.getUserGender());
            }

            if (obj.getUserLocation() != null && obj.getUserLocation() != "") {
                entity.setUserLocation(obj.getUserLocation());
            } else {
                entity.setUserLocation(dbData.getUserLocation());
            }

            if (obj.getUserContact() != null && obj.getUserContact() != "") {
                entity.setUserContact(obj.getUserContact());
            } else {
                entity.setUserContact(dbData.getUserContact());
            }

            if (obj.getUserWebsite() != null && obj.getUserWebsite() != "") {
                entity.setUserWebsite(obj.getUserWebsite());
            } else {
                entity.setUserWebsite(dbData.getUserWebsite());
            }

            if (obj.getUserProfilePic() != null) {
                entity.setUserProfilePic(obj.getUserProfilePic());
            } else {
                entity.setUserProfilePic(dbData.getUserProfilePic());
            }

            if (obj.getUserCoverPicture() != null) {
                entity.setUserCoverPicture(obj.getUserCoverPicture());
            } else {
                entity.setUserCoverPicture(dbData.getUserCoverPicture());
            }

            if (obj.getLinkedInURL() != null && obj.getLinkedInURL() != "") {
                entity.setLinkedInURL(obj.getLinkedInURL());
            } else {
                entity.setLinkedInURL(dbData.getLinkedInURL());
            }

            if (obj.getGitHubURL() != null && obj.getGitHubURL() != "") {
                entity.setGitHubURL(obj.getGitHubURL());
            } else {
                entity.setGitHubURL(dbData.getGitHubURL());
            }

            if (obj.getFacebookURL() != null && obj.getFacebookURL() != "") {
                entity.setFacebookURL(obj.getFacebookURL());
            } else {
                entity.setFacebookURL(dbData.getFacebookURL());
            }

            if (obj.getYoutubeURL() != null && obj.getYoutubeURL() != "") {
                entity.setYoutubeURL(obj.getYoutubeURL());
            } else {
                entity.setYoutubeURL(dbData.getYoutubeURL());
            }

            return new UserDaw(repo.save(entity));
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        try {
            repo.deleteById(userId);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<PostDaw> allPosts(Integer userId) {
        try {

            PostService obj = new PostService();

            return obj.getAllPostByUser(userId);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public UserDaw login(String email, String password) {
        try {
            List<UserEntity> entity = repo.findByEmailId(email);
            UserEntity user = entity.get(0);
            if (user.getPassword().equals(password)) {
                return new UserDaw(user);
            } else {
                return new UserDaw(null);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDaw getDataByEmail(String email) {
        try {
            List<UserEntity> entity = repo.findByEmailId(email);
            UserEntity user = entity.get(0);
            return new UserDaw(user);
        } catch (Exception e) {
            System.out.println(e);
            return getUserDetails(0);
        }
    }

    @Override
    public UserDaw updatePicture(Integer userId, UserDaw obj) {
        try {
            UserEntity entity = new UserEntity();
            UserEntity dbData = repo.findById(userId).orElseThrow();
            entity.setUserId(userId);

            if (obj.getEmailId() != null && obj.getEmailId() != "") {
                entity.setEmailId(obj.getEmailId());
            } else {
                entity.setEmailId(dbData.getEmailId());
            }

            if (obj.getPassword() != null && obj.getPassword() != "") {
                entity.setPassword(obj.getPassword());
            } else {
                entity.setPassword(dbData.getPassword());
            }

            if (obj.getUserName() != null && obj.getUserName() !="") {
                entity.setUserName(obj.getUserName());
            } else {
                entity.setUserName(dbData.getUserName());
            }

            if (obj.getUserLastName() != null && obj.getUserLastName() != "") {
                entity.setUserLastName(obj.getUserLastName());
            } else {
                entity.setUserLastName(dbData.getUserLastName());
            }

            if (obj.getUserDOB() != null) {
                entity.setUserDOB(obj.getUserDOB());
            } else {
                entity.setUserDOB(dbData.getUserDOB());
            }

            if (obj.getUserBio() != null && obj.getUserBio() != "") {
                entity.setUserBio(obj.getUserBio());
            } else {
                entity.setUserBio(dbData.getUserBio());
            }

            if (obj.getUserNationality() != null && obj.getUserNationality() != "") {
                entity.setUserNationality(obj.getUserNationality());
            } else {
                entity.setUserNationality(dbData.getUserNationality());
            }

            if (obj.getUserGender() != null && obj.getUserGender() != "") {
                entity.setUserGender(obj.getUserGender());
            } else {
                entity.setUserGender(dbData.getUserGender());
            }

            if (obj.getUserLocation() != null && obj.getUserLocation() != "") {
                entity.setUserLocation(obj.getUserLocation());
            } else {
                entity.setUserLocation(dbData.getUserLocation());
            }

            if (obj.getUserContact() != null && obj.getUserContact() != "") {
                entity.setUserContact(obj.getUserContact());
            } else {
                entity.setUserContact(dbData.getUserContact());
            }

            if (obj.getUserWebsite() != null && obj.getUserWebsite() != "") {
                entity.setUserWebsite(obj.getUserWebsite());
            } else {
                entity.setUserWebsite(dbData.getUserWebsite());
            }

            if (obj.getUserProfilePic() != null) {
                entity.setUserProfilePic(obj.getUserProfilePic());
            } else {
                entity.setUserProfilePic(dbData.getUserProfilePic());
            }

            if (obj.getUserCoverPicture() != null) {
                entity.setUserCoverPicture(obj.getUserCoverPicture());
            } else {
                entity.setUserCoverPicture(dbData.getUserCoverPicture());
            }

            if (obj.getLinkedInURL() != null && obj.getLinkedInURL() != "") {
                entity.setLinkedInURL(obj.getLinkedInURL());
            } else {
                entity.setLinkedInURL(dbData.getLinkedInURL());
            }

            if (obj.getGitHubURL() != null && obj.getGitHubURL() != "") {
                entity.setGitHubURL(obj.getGitHubURL());
            } else {
                entity.setGitHubURL(dbData.getGitHubURL());
            }

            if (obj.getFacebookURL() != null && obj.getFacebookURL() != "") {
                entity.setFacebookURL(obj.getFacebookURL());
            } else {
                entity.setFacebookURL(dbData.getFacebookURL());
            }

            if (obj.getYoutubeURL() != null && obj.getYoutubeURL() != "") {
                entity.setYoutubeURL(obj.getYoutubeURL());
            } else {
                entity.setYoutubeURL(dbData.getYoutubeURL());
            }

            return new UserDaw(repo.save(entity));
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
            return null;
        }
    }

    public void addFriend(Integer userId, Integer friendId) {
        Optional<UserEntity> user = repo.findById(userId);
        Optional<UserEntity> friend = repo.findById(friendId);
        if (user.isPresent() && friend.isPresent()) {
            UserEntity u = user.get();
            UserEntity f = friend.get();
            u.getFriends().add(f);
            f.getFriends().add(u);
            repo.save(u);
            repo.save(f);
        }
    }

    public Set<UserEntity> getFriends(Integer userId) {
        return repo.findById(userId).map(UserEntity::getFriends).orElse(new HashSet<>());
    }

}
