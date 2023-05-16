package com.info.user.controller;

import com.info.user.exception.InvalidUserNameOrPasswordException;
import com.info.user.model.AuthRequestModel;
import com.info.user.model.TokenResponseModel;
import com.info.user.service.SignInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private SignInService signInService;

    @PostMapping("/signin")
    public ResponseEntity<TokenResponseModel> signIn(@RequestBody AuthRequestModel authRequestModel) {
        try {
            return new ResponseEntity<>(signInService.signIn(authRequestModel), HttpStatus.OK);
        }
        catch(InvalidUserNameOrPasswordException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
