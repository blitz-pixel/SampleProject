package com.example.SampleLoginApplication.Controllers;

import com.example.SampleLoginApplication.Models.User;
import com.example.SampleLoginApplication.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody User user) throws JsonProcessingException {

        try {
            userService.InsertDataIntoDatabase(user);
            String jsonString = objectMapper.writeValueAsString(user);
            log.info(jsonString);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @GetMapping("/users")
    public List<User> login() {
        return userService.getUserData();
    }
}
