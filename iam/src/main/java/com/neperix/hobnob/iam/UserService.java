package com.neperix.hobnob.iam;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

/**
 * @author petarmitrovic
 */
@Component
@AllArgsConstructor
class UserService {

    private final UserRepository userRepository;

    List<User> allUsers() {
        return this.userRepository.findAll();
    }

    void createNew(String username, String email, Set<String> roles) {
        User newUser = User.builder()
                .uuid(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .roles(roles)
                .build();
        this.userRepository.save(newUser);
    }
}