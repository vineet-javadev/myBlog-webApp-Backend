package com.example.blog_app.ServiceInterface;

import java.util.List;

import com.example.blog_app.Daw.PostDaw;
import com.example.blog_app.Daw.UserDaw;

public interface UserServiceInterface {

    public List<UserDaw> getAllUsers();

    public String getUserPass(Integer userId);

    public UserDaw getUserDetails(Integer userId);

    public UserDaw postData(UserDaw obj);

    public UserDaw UpdateUser(Integer userId, String pass, UserDaw obj);

    public UserDaw updatePicture(Integer userId, UserDaw obj);

    public Boolean deleteUser(Integer userId);

    public List<PostDaw> allPosts(Integer userId);

    public UserDaw login(String email, String password);

    public UserDaw getDataByEmail(String email);
}