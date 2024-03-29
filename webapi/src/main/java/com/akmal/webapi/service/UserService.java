package com.akmal.webapi.service;

import com.akmal.webapi.domain.Role;
import com.akmal.webapi.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
