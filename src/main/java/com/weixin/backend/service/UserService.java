package com.weixin.backend.service;

import com.weixin.backend.dao.UserRepository;
import com.weixin.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUser(String id) {
        return userRepository.getById(id);
    }

    public User updateUser(String id) {
        return userRepository.updateUser(id);
    }
}
