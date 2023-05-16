package com.info.user.service;

import com.info.user.entity.Contact;
import com.info.user.model.ContactSaveModel;
import com.info.user.model.ContactUpdateModel;

import java.util.List;

public interface ContactService {

    Contact findById(long id);
    void save(ContactSaveModel contact);
    void update(ContactUpdateModel contact);
    void delete(long id);
    List<Contact> findAll();
}
