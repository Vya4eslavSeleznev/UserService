package com.info.user.repository.Impl;

import com.info.user.entity.Contact;
import com.info.user.repository.ContactDao;
import com.info.user.repository.factory.HibernateSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Override
    public Contact findById(long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Contact.class, id);
    }

    @Override
    public void save(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public List<Contact> findAll() {
        return null;
    }
}
