package com.example.roads.services;

import com.example.roads.entities.UserLogin;
import com.example.roads.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired

    private UserLoginRepository userLoginRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDatails loadUserByUsername(String username){
        Optional<UserLogin> opt = UserLoginRepository.findByUsername(username);



    }
}
