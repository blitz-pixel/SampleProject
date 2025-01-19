package com.example.SampleLoginApplication.Repositories;

import com.example.SampleLoginApplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
