package com.info.user.service.impl;

import com.info.user.entity.Contact;
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
    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
