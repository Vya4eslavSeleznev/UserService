package com.info.user.service;

import com.info.user.entity.Contact;
import com.info.user.model.*;

import java.util.List;

public interface CustomerService {

    FindCustomerModel findById(long id);
    void save(CustomerSaveModel customerSaveModel);
    void update(CustomerUpdateModel customerUpdateModel);
    void delete(long id);
    List<FindCustomerModel> findAll();
}
