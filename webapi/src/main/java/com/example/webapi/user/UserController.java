package com.example.webapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> GetUsers() {
        return userService.GetUsers();
    }

    @GetMapping(path = "{userId}")
    public User GetUserById(@PathVariable("userId") Long userId) {
        return userService.GetUsersById(userId);
    }

    @PatchMapping
    public void UpdateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
    }

}
