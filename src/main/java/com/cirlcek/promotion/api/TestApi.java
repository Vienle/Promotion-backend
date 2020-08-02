package com.cirlcek.promotion.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test")
@CrossOrigin
public class TestApi {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity test(){
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
