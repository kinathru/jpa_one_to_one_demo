package com.example.jpa.jpa_one_to_one_demo.repository;

import com.example.jpa.jpa_one_to_one_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
