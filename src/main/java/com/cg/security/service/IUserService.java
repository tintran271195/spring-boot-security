package com.cg.security.service;

import com.cg.security.model.Role;
import com.cg.security.model.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

}
