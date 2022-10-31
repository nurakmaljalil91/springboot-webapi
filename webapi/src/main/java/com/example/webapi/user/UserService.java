package com.example.webapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        var email = userRepository.findUserByEmail(user.getEmail());

        if (email.isPresent()) {
            throw new IllegalMonitorStateException("email already exists");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        var exists = userRepository.existsById(id);

        if (!exists) throw new IllegalStateException("user with id " + id + " is not exists");

        userRepository.deleteById(id);
    }

    public User GetUsersById(Long userId) {
        var exists = userRepository.existsById(userId);

        if (!exists) throw new IllegalStateException("user with id " + userId + " is not exists");

        return userRepository.findById(userId).get();
    }

    @Transactional
    public void updateUser(User updatedUser) {
        var user = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new IllegalStateException("user with id " + updatedUser.getId() + " is not exists"));

        if (updatedUser.getUsername() != null && updatedUser.getUsername().length() > 0 && !Objects.equals(user.getUsername(), updatedUser.getUsername())) {
            user.setUsername(updatedUser.getUsername());
        }
    }
}
