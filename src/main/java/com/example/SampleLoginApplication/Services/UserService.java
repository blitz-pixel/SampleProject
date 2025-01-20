package com.example.SampleLoginApplication.Services;

import com.example.SampleLoginApplication.Models.User;
import com.example.SampleLoginApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.StreamSupport.stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void InsertDataIntoDatabase(User user){
        userRepository.save(user);
    }

    public List<User> getUserData(){
        Iterable<User> users  = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)  // Correct usage of StreamSupport
                .collect(Collectors.toList());
    }
}
