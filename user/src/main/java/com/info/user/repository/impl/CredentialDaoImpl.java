package com.info.user.repository.impl;

import com.info.user.entity.Credential;
import com.info.user.repository.CredentialDao;
import com.info.user.repository.factory.HibernateSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialDaoImpl implements CredentialDao {

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
