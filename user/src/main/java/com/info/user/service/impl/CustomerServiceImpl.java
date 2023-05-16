package com.info.user.service.impl;

import com.info.user.entity.Contact;
import com.info.user.entity.Credential;
import com.info.user.entity.Customer;
import com.info.user.model.CustomerSaveModel;
import com.info.user.model.CustomerUpdateModel;
import com.info.user.model.FindCustomerModel;
import com.info.user.repository.ContactDao;
import com.info.user.repository.CredentialDao;
import com.info.user.repository.CustomerDao;
import com.info.user.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private ContactDao contactDao;
    private CredentialDao credentialDao;

    @Override
    public FindCustomerModel findById(long id) {
        Customer customer = customerDao.findById(id);

        return new FindCustomerModel(
          customer.getId(),
          customer.getName(),
          customer.getSurname(),
          customer.getLastName(),
          customer.getCredential().getLogin(),
          customer.getContact().getEmail(),
          customer.getContact().getPhone()
        );
    }

    @Override
    public void save(CustomerSaveModel customerSaveModel) {
        Contact contact = contactDao.save(
          new Contact(customerSaveModel.getEmail(), customerSaveModel.getPhone())
        );

        Credential credential = credentialDao.save(
          new Credential(customerSaveModel.getLogin(), customerSaveModel.getPassword())
        );

        customerDao.save(
            new Customer(
              customerSaveModel.getName(),
              customerSaveModel.getSurname(),
              customerSaveModel.getLastName(),
              contact,
              credential
            )
        );
    }

    @Override
    public void update(CustomerUpdateModel customerUpdateModel) {
        Contact contact = new Contact(
          customerUpdateModel.getContactId(),
          customerUpdateModel.getEmail(),
          customerUpdateModel.getPhone()
        );

        Credential credential = new Credential(
          customerUpdateModel.getCredentialId(),
          customerUpdateModel.getLogin(),
          customerUpdateModel.getPassword()
        );

        contactDao.update(contact);
        credentialDao.update(credential);

        customerDao.update(
          new Customer(
            customerUpdateModel.getId(),
            customerUpdateModel.getName(),
            customerUpdateModel.getSurname(),
            customerUpdateModel.getLastName(),
            contact,
            credential
          )
        );
    }

    @Override
    public void delete(long id) {
        customerDao.delete(id);
    }

    @Override
    public List<FindCustomerModel> findAll() {
        List<Customer> customers = customerDao.findAll();

        return customers
          .stream()
          .map(elem -> new FindCustomerModel(
            elem.getId(),
            elem.getName(),
            elem.getSurname(),
            elem.getLastName(),
            elem.getCredential().getLogin(),
            elem.getContact().getEmail(),
            elem.getContact().getEmail()))
          .collect(Collectors.toList());
    }
}
