package com.info.user.service;

import com.info.user.model.CustomerSaveModel;
import com.info.user.model.CustomerUpdateModel;
import com.info.user.model.FindCustomerModel;

import java.util.List;

public interface CustomerService {

    FindCustomerModel findById(long id);
    void save(CustomerSaveModel customerSaveModel);
    void update(CustomerUpdateModel customerUpdateModel);
    void delete(long id);
    List<FindCustomerModel> findAll();
}
