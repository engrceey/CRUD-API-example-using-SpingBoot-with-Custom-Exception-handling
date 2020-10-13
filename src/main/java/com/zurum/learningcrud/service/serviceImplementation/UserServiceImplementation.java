package com.zurum.learningcrud.service.serviceImplementation;

import com.zurum.learningcrud.exception.ResourceNotFoundException;
import com.zurum.learningcrud.model.User;
import com.zurum.learningcrud.repository.UserRepository;
import com.zurum.learningcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id +" id not found in database"));
    }

    @Override
    public String deleteUserById(long id) {
        userRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        assert existingUser != null;
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setStack(user.getStack());
        return userRepository.save(existingUser);
    }
}
