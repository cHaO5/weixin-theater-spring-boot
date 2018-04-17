package com.weixin.backend.dao;

import com.weixin.backend.entity.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie, Integer> {
}
