package com.example.blog_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_app.Daw.UserDaw;
import com.example.blog_app.Entities.UserEntity;
import com.example.blog_app.Services.UserService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping()
    public List<UserDaw> getAllUsers() {
       return service.getAllUsers();
    }

    @GetMapping("/{userId}")
    public String getUserPass(@PathVariable Integer userId) {
        return service.getUserPass(userId);
    }

    @GetMapping("userId/{userId}")
    public UserDaw getUserDetails(@PathVariable Integer userId) {
       return service.getUserDetails(userId);
    }

    @PostMapping()
    public UserDaw postData(@RequestBody UserDaw obj) {
       return service.postData(obj);
    }

    @PutMapping("/{userId}/{pass}")
    public UserDaw UpdateUser(@PathVariable Integer userId, @PathVariable String pass, @RequestBody UserDaw obj) {
        return service.UpdateUser(userId, pass , obj);
    }

    @PutMapping("/{userId}")
    public UserDaw UpdatePicture(@PathVariable Integer userId, @RequestBody UserDaw obj) {
        return service.updatePicture(userId, obj);
    }

    @DeleteMapping("/{userId}")
    public Boolean deleteUser(@PathVariable Integer userId){
        return service.deleteUser(userId);
    }

    @GetMapping("login/{email}/{password}")
    public UserDaw getMethodName(@PathVariable String email , @PathVariable String password) {
        return service.login(email , password);
    }
    
    @GetMapping("email/{email}")
    public UserDaw getDataByEmail(@PathVariable String email){
        return service.getDataByEmail(email);
    }

    @PostMapping("/{userId}/addFriend/{friendId}")
    public void addFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        service.addFriend(userId, friendId);
    }

    @GetMapping("/{id}/friends")
    public Set<UserEntity> getFriends(@PathVariable Integer id) {
        return service.getFriends(id);
    }

}
