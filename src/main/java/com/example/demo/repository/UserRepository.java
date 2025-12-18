package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.User;

public interface User extends JpaRepository<User,Long>{
    
}