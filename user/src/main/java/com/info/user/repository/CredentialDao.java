package com.info.user.repository;

import com.info.user.entity.Credential;

public interface CredentialDao {

    Credential findCredentialByUsername(String username);
}
