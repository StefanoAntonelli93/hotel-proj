package com.example.hotel_proj.service;

import com.example.hotel_proj.entity.User;
import com.example.hotel_proj.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(@Autowired UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(String username, String password, String email) {
        User user = new User(username, password,email);
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public Optional<User> getUserId(Long id){
        return repository.findById(id);

    }
    public Optional<User> getUserName(String username){
        return repository.findByUsername(username);
    }
    public void addUser(User user){
        repository.save(user);
    }
    public void updateUser(User user){
        repository.save(user);
    }
    public boolean deleteUser(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
