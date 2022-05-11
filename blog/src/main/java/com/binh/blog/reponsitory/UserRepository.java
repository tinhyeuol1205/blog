package com.binh.blog.reponsitory;

import com.binh.blog.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUserName(String userName);
}
