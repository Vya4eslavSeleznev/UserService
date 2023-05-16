package com.info.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.info.user.exception.InvalidUserNameOrPasswordException;
import com.info.user.model.AuthRequestModel;
import com.info.user.model.TokenResponseModel;

public interface SignInService {

    TokenResponseModel signIn(AuthRequestModel authRequestModel)
      throws JsonProcessingException, InvalidUserNameOrPasswordException;
}
