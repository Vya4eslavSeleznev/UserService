package com.info.user.service.impl;

import com.info.user.entity.Contact;
import com.info.user.model.ContactSaveModel;
import com.info.user.model.ContactUpdateModel;
import com.info.user.repository.ContactDao;
import com.info.user.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;

    @Override
    public Contact findById(long id) {
        return contactDao.findById(id);
    }

    @Override
    public void save(ContactSaveModel contact) {
        contactDao.save(
          new Contact(contact.getEmail(), contact.getPhone())
        );
    }

    @Override
    public void update(ContactUpdateModel contact) {
        contactDao.update(
          new Contact(contact.getId(), contact.getEmail(), contact.getPhone())
        );
    }

    @Override
    public void delete(long id) {
        contactDao.delete(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
