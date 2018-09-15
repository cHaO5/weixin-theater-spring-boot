package com.weixin.backend.service;

import com.weixin.backend.entity.User;

import java.util.Map;

public interface UserService {
    User getUser(String id);

    boolean updateUser(String id, Map<String, Object> info);
}
