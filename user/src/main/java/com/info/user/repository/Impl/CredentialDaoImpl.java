package com.info.user.repository.Impl;

import com.info.user.entity.Credential;
import com.info.user.repository.CredentialDao;
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
public class CredentialDaoImpl implements CredentialDao {

    @Override
    public Credential findById(long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Credential.class, id);
    }

    @Override
    public void save(Credential credential) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(credential);
        transaction.commit();
        session.close();
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
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Credential credential = session.load(Credential.class, id);
        session.delete(credential);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Credential> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Credential> cq = cb.createQuery(Credential.class);
        Root<Credential> rootEntry = cq.from(Credential.class);
        CriteriaQuery<Credential> all = cq.select(rootEntry);
        TypedQuery<Credential> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
