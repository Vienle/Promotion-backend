package com.cirlcek.promotion.api;

import com.cirlcek.promotion.dtos.CredentialDto;
import com.cirlcek.promotion.dtos.UserDto;
import com.cirlcek.promotion.entities.Credentials;
import com.cirlcek.promotion.entities.Users;
import com.cirlcek.promotion.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class LoginApi {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserDto users){
        try{
            System.out.println("Api usser : " + users.getStaffcode());
            Credentials credentials = loginService.checkLogin(users);
            return new ResponseEntity(new CredentialDto(credentials),HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity("Account not exist",HttpStatus.FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getHeader(@RequestHeader("Authorization") String stringHeader){
        if (stringHeader == null){
            return new ResponseEntity<>("null",HttpStatus.BAD_REQUEST);
        }
        String[] tokenParam = stringHeader.split("Bearer ");
//        for (String a:tokenParam
//             ) {
//            System.out.println(a);
//        }
        System.out.println(tokenParam[1]);
        return new ResponseEntity(stringHeader,HttpStatus.OK);
    }
}
