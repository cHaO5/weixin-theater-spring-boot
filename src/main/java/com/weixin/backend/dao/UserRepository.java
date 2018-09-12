package com.weixin.backend.dao;

import com.weixin.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String id);

    @Query("update User set nickname = ?2, name = ?3, " +
            "avatar = ?3, department = ?4, grade = ?5 where id = ?1")
    boolean updateUser(String id, String nickname, String name,
                       String avatar, String department,String grade);
}
