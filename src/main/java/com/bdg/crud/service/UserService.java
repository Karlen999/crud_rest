package com.bdg.crud.service;

import com.bdg.crud.model.User;
import com.bdg.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User item : iterable) {
            list.add(item);
        }
        return list;
    }

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User deleteById(int id){
        User user = getUser(id);

        if (user != null) {
            userRepository.deleteById(id);
        }
        return user;
    }

    public void updateUser(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }
}
