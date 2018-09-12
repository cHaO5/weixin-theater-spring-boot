package com.weixin.backend.service;

import com.weixin.backend.dao.UserRepository;
import com.weixin.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUser(String id) {
        return userRepository.findById(id);
    }

    public boolean updateUser(String id, Map<String, Object> info) {
        return userRepository.updateUser(
                id,
                (String) info.get("nickname"),
                (String) info.get("name"),
                (String) info.get("avatar"),
                (String) info.get("department"),
                (String) info.get("grade"));
    }
}
