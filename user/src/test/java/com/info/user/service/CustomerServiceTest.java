package com.info.user.service;

import com.info.user.entity.Contact;
import com.info.user.entity.Credential;
import com.info.user.entity.Customer;
import com.info.user.model.CustomerSaveModel;
import com.info.user.model.CustomerUpdateModel;
import com.info.user.model.FindCustomerModel;
import com.info.user.model.Role;
import com.info.user.repository.CustomerDao;
import com.info.user.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerDao customerDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    private long id;
    private String name;
    private String surname;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private Customer customer;
    private String password;

    @BeforeEach
    public void init() {
        id = 1;
        name = "name";
        surname = "surname";
        lastName = "lastName";
        username = "login";
        email = "email@gmail.com";
        phone = "8999776655";
        password = "pwd";

        customer = new Customer(
          id, name, surname, lastName,
          new Contact(email, phone),
          new Credential(Role.USER, password, username)
        );
    }

    @Test
    public void should_find_by_id_find_customer_model_returned() {
        FindCustomerModel expectedModel = new FindCustomerModel(
          id, name, surname, lastName, username, email, phone
        );

        when(customerDao.findById(id)).thenReturn(customer);

        FindCustomerModel actualModel = customerService.findById(id);

        verify(customerDao, times(1)).findById(id);

        assertEquals(expectedModel.getId(), actualModel.getId());
        assertEquals(expectedModel.getName(), actualModel.getName());
        assertEquals(expectedModel.getSurname(), actualModel.getSurname());
        assertEquals(expectedModel.getLastName(), actualModel.getLastName());
        assertEquals(expectedModel.getUsername(), actualModel.getUsername());
        assertEquals(expectedModel.getEmail(), actualModel.getEmail());
        assertEquals(expectedModel.getPhone(), actualModel.getPhone());
    }

    @Test
    public void should_save_customer() {
        CustomerSaveModel customerSaveModel = new CustomerSaveModel(
          name, surname, lastName, email, phone, username, password
        );

        when(passwordEncoder.encode(password)).thenReturn(password);

        customerService.save(customerSaveModel);

        verify(customerDao, times(1)).save(any(Customer.class), any(Contact.class), any(Credential.class));
    }

    @Test
    public void should_update_customer() {
        CustomerUpdateModel customerUpdateModel = new CustomerUpdateModel(
          id, 4, 4, name, surname, lastName, email, phone
        );

        customerService.update(customerUpdateModel);

        verify(customerDao, times(1)).update(any(Customer.class), any(Contact.class), any(Long.class));
    }

    @Test
    public void should_delete_customer() {
        customerService.delete(id);

        verify(customerDao, times(1)).delete(id);
    }

    @Test
    public void should_find_all_customers_list_returned() {
        List<Customer> customerList = List.of(customer);

        when(customerDao.findAll()).thenReturn(customerList);

        List<FindCustomerModel> actualList = customerService.findAll();

        verify(customerDao, times(1)).findAll();

        assertEquals(customerList.get(0).getId(), actualList.get(0).getId());
        assertEquals(customerList.get(0).getName(), actualList.get(0).getName());
        assertEquals(customerList.get(0).getSurname(), actualList.get(0).getSurname());
        assertEquals(customerList.get(0).getLastName(), actualList.get(0).getLastName());
        assertEquals(customerList.get(0).getCredential().getUsername(), actualList.get(0).getUsername());
        assertEquals(customerList.get(0).getContact().getEmail(), actualList.get(0).getEmail());
        assertEquals(customerList.get(0).getContact().getPhone(), actualList.get(0).getPhone());

    }
}
























