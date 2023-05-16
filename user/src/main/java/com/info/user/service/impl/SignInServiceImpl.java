package com.info.user.service.impl;

import com.info.user.entity.Credential;
import com.info.user.exception.InvalidUserNameOrPasswordException;
import com.info.user.model.AuthRequestModel;
import com.info.user.model.TokenResponseModel;
import com.info.user.security.jwt.JwtTokenProvider;
import com.info.user.service.SignInService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class SignInServiceImpl implements SignInService {

    private CustomUserDetailsService userDetailsService;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public TokenResponseModel signIn(AuthRequestModel request)
      throws InvalidUserNameOrPasswordException {
        Credential user = userDetailsService.getAuthenticatedUser(request.getUsername(), request.getPassword());
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole());

        Map<Object, Object> model = new HashMap<>();
        model.put("token", token);

        return new TokenResponseModel(model.get("token").toString());
    }
}
