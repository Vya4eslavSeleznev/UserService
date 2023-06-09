package com.info.user.repository.impl;

import com.info.user.entity.Contact;
import com.info.user.repository.ContactDao;
import com.info.user.repository.factory.HibernateSessionFactory;
import org.hibernate.Session;
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
