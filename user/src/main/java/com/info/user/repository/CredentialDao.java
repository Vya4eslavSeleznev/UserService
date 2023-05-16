package com.info.user.repository;

import com.info.user.entity.Credential;

public interface CredentialDao {

    Credential save(Credential credential);
    void update(Credential credential);
    Credential findCredentialByUsername(String username);
}
