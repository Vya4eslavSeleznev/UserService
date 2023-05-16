package com.info.user.repository.impl;

import com.info.user.entity.Credential;
import com.info.user.repository.CredentialDao;
import com.info.user.repository.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialDaoImpl implements CredentialDao {

    @Override
    public Credential save(Credential credential) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(credential);
        transaction.commit();
        session.close();

        return credential;
    }

    @Override
    public void update(Credential credential) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(credential);
        transaction.commit();
        session.close();
    }

    @Override
    public Credential findCredentialByUsername(String username) {

        return (Credential) HibernateSessionFactory
          .getSessionFactory()
          .openSession()
          .createQuery("from Credential where username =:username")
          .setParameter("username", username)
          .uniqueResult();
    }
}
