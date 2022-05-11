package com.binh.blog.service;

import java.util.List;

import com.binh.blog.model.User;
import com.binh.blog.reponsitory.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
    public User getUser(String userName){
        return userRepository.findByUserName(userName);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
