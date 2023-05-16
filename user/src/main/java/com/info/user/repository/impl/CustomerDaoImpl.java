package com.info.user.repository.impl;

import com.info.user.entity.Customer;
import com.info.user.repository.CustomerDao;
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
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findById(long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class, id);
        session.delete(customer);
        session.delete(customer.getContact());
        session.delete(customer.getCredential());
        transaction.commit();
        session.close();
    }

    @Override
    public List<Customer> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
