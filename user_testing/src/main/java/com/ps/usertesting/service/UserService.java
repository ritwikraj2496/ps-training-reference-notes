package com.ps.usertesting.service;

import com.ps.usertesting.model.User;
import com.ps.usertesting.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //OR

    // UserRepository userRepository = new UserRepository(); //new keyword is not advised to be used

    // Business method to test
    public String getUserNameById(int id) {
        User user = userRepository.findById(id);
        return (user != null) ? user.getName() : "Unknown User";
    }
}
