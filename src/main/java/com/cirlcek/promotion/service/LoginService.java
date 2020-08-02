package com.cirlcek.promotion.service;

import com.cirlcek.promotion.dtos.UserDto;
import com.cirlcek.promotion.entities.Credentials;
import com.cirlcek.promotion.entities.Users;
import com.cirlcek.promotion.repository.CredentialsRepository;
import com.cirlcek.promotion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;
    public Credentials checkLogin(UserDto users){
        Users users1 = userRepository.getFirstByStaffcode(users.getStaffcode()).orElse(null);
        System.out.println("Staff : " + users.getStaffcode());
        System.out.println("Pass : " + users.getPassword());
        if (users1 == null){
            return null;
        }
        if (!users1.getPassword().equals(users.getPassword())){
            return null;
        }
        Credentials credentials = new Credentials();
        credentials.setRefreshToken(UUID.randomUUID().toString());
        credentials.setUser(users1);
        credentialsRepository.save(credentials);
        return credentials;
    }

    public String checkToken(String tokenParam){
        System.out.println("Service check token : " + tokenParam);
        String token = tokenParam.split("Bearer ")[1];
        System.out.println("Service token spilit : "+ token);
        Credentials credentials = credentialsRepository.getFirstByAcessToken(token).orElse(null);
        if (credentials == null){
            return null;
        }
        String staffcode = credentials.getUser().getStaffcode();
        if (staffcode == null){
            return null;
        }
        return staffcode;
    }
}
