package com.info.user.repository;

import com.info.user.entity.Contact;
import com.info.user.entity.Credential;
import com.info.user.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findById(long id);
    void save(Customer customer, Contact contact, Credential credential);
    void update(Customer customer, Contact contact, long credentialId);
    void delete(long id);
    List<Customer> findAll();
}
