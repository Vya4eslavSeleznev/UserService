package com.info.user.service;

import com.info.user.entity.Contact;
import com.info.user.repository.ContactDao;
import com.info.user.service.impl.ContactServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @InjectMocks
    private ContactServiceImpl contactService;

    @Mock
    private ContactDao contactDao;

    private Contact expectedContact;

    @BeforeEach
    public void init() {
        expectedContact = new Contact(
          "email",
          "7999887766"
        );
    }

    @Test
    public void should_find_by_id_contact_returned() {
        long id = 4;

        when(contactDao.findById(id)).thenReturn(expectedContact);

        Contact actualContact = contactService.findById(id);

        verify(contactDao, times(1)).findById(id);

        assertEquals(expectedContact.getEmail(), actualContact.getEmail());
        assertEquals(expectedContact.getPhone(), actualContact.getPhone());
    }

    @Test
    public void should_find_all_list_returned() {
        List<Contact> expectedContactList = List.of(expectedContact);

        when(contactDao.findAll()).thenReturn(expectedContactList);

        List<Contact> actualContactList = contactService.findAll();

        verify(contactDao, times(1)).findAll();

        assertEquals(expectedContactList.get(0).getEmail(), actualContactList.get(0).getEmail());
        assertEquals(expectedContactList.get(0).getPhone(), actualContactList.get(0).getPhone());
    }
}




























