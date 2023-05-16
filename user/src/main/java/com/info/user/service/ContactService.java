package com.info.user.service;

import com.info.user.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact findById(long id);
    List<Contact> findAll();
}
