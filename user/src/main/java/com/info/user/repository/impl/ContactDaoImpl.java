package com.info.user.repository.impl;

import com.info.user.entity.Contact;
import com.info.user.repository.ContactDao;
import com.info.user.repository.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Override
    public Contact findById(long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Contact.class, id);
    }

    @Override
    public long save(Contact contact) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(contact);
        transaction.commit();
        session.close();

        return contact.getId();
    }

    @Override
    public void update(Contact contact) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(contact);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Contact contact = session.load(Contact.class, id);
        session.delete(contact);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Contact> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
        Root<Contact> rootEntry = cq.from(Contact.class);
        CriteriaQuery<Contact> all = cq.select(rootEntry);
        TypedQuery<Contact> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
