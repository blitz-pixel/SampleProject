package com.example.SampleLoginApplication.Services;

import com.example.SampleLoginApplication.Models.User;
import com.example.SampleLoginApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void InsertDataIntoDatabase(User user){
        userRepository.save(user);
    }
}
