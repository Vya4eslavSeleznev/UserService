package com.info.user.repository;

import com.info.user.entity.Contact;

import java.util.List;

public interface ContactDao {

    Contact findById(long id);
    Contact save(Contact contact);
    void update(Contact contact);
    List<Contact> findAll();
}
