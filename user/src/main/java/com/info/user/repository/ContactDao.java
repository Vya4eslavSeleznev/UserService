package com.info.user.repository;

import com.info.user.entity.Contact;

import java.util.List;

public interface ContactDao {

    Contact findById(long id);
    List<Contact> findAll();
}
