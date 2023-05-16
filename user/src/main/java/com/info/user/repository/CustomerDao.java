package com.info.user.repository;

import com.info.user.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findById(long id);
    void save(Customer customer);
    void update(Customer customer);
    void delete(long id);
    List<Customer> findAll();
}
