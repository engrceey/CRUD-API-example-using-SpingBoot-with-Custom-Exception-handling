package com.zurum.learningcrud.service;

import com.zurum.learningcrud.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> saveUsers(List<User> user);

    List<User> getUsers();

    User getUserById(long id);

    String deleteUserById(long id);

    User updateUser(User user);

}
