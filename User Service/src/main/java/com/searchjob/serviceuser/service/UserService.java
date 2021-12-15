package com.searchjob.serviceuser.service;

import com.searchjob.serviceuser.repository.UserRepository;
import com.searchjob.serviceuser.repository.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class UserService {
    private final UserRepository userRepository;

    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    public User fetchById(long id) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepository.findById(id);

        if(maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");
        else return maybeUser.get();
    }

    public long create(String firstname, String lastname,
                       String email){
        final User user = new User(firstname, lastname, email);
        final User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    public void update(long id, String firstname, String lastname,
                       String email) throws IllegalArgumentException {

        final Optional<User> maybeUser = userRepository.findById(id);
        if(maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");

        final User user = maybeUser.get();
        if(firstname != null && !firstname.isBlank()) user.setFirstname(firstname);
        if(lastname != null && !lastname.isBlank()) user.setLastname(lastname);

        userRepository.save(user);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }
}
