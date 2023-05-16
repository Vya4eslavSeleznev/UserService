package com.info.user.service.impl;

import com.info.user.entity.Credential;
import com.info.user.exception.InvalidUserNameOrPasswordException;
import com.info.user.repository.CredentialDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private CredentialDao credentialDao;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = credentialDao.findCredentialByUsername(username);

        if(credential == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return credential;
    }

    public Credential getAuthenticatedUser(String username, String password)
      throws InvalidUserNameOrPasswordException {
        Credential user = credentialDao.findCredentialByUsername(username);

        if (user == null) {
            throw new InvalidUserNameOrPasswordException();
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidUserNameOrPasswordException();
        }

        return user;
    }
}
