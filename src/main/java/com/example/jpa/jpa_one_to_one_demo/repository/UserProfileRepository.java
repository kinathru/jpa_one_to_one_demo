package com.example.jpa.jpa_one_to_one_demo.repository;

import com.example.jpa.jpa_one_to_one_demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>
{
}
