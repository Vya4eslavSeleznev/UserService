package com.info.user.repository;

import com.info.user.entity.Credential;

import java.util.List;

public interface CredentialDao {

    Credential findById(long id);
    Credential save(Credential credential);
    void update(Credential credential);
    void delete(long id);
    List<Credential> findAll();
}
