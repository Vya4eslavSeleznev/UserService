package com.info.user.service;

import com.info.user.entity.Credential;
import com.info.user.exception.InvalidUserNameOrPasswordException;
import com.info.user.model.Role;
import com.info.user.repository.CredentialDao;
import com.info.user.service.impl.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private CredentialDao credentialDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    private String username;
    private String password;
    private Credential credential;

    @BeforeEach
    public void init() {
        username = "username";
        password = "pwd";
        credential = new Credential(Role.USER, password, username);
    }

    @Test
    public void should_load_user_by_username_returned_user_details() {
        when(credentialDao.findCredentialByUsername(username)).thenReturn(credential);

        UserDetails actualUD = customUserDetailsService.loadUserByUsername(username);

        verify(credentialDao, times(1)).findCredentialByUsername(username);

        assertEquals(credential, actualUD);
    }

    @Test
    public void should_not_load_user_by_username_exception() {
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername(username));
    }

    @Test
    public void should_get_authenticated_user_returned_user_credential() throws InvalidUserNameOrPasswordException {
        when(credentialDao.findCredentialByUsername(username)).thenReturn(credential);
        when(passwordEncoder.matches(password, password)).thenReturn(true);

        Credential actualCredential = customUserDetailsService.getAuthenticatedUser(username, password);

        verify(credentialDao, times(1)).findCredentialByUsername(username);

        assertEquals(credential, actualCredential);
    }

    @Test
    public void should_get_empty_user_exception() {
        assertThrows(InvalidUserNameOrPasswordException.class, () ->
          customUserDetailsService.getAuthenticatedUser(username, password));
    }

    @Test
    public void should_get_incorrect_password_exception() {
        when(credentialDao.findCredentialByUsername(username)).thenReturn(credential);
        when(passwordEncoder.matches(password, password)).thenReturn(false);
        assertThrows(InvalidUserNameOrPasswordException.class, () ->
          customUserDetailsService.getAuthenticatedUser(username, password));
    }
}
