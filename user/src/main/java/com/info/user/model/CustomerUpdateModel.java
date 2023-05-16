package com.info.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CustomerUpdateModel {

    private long id;
    private long contactId;
    private long credentialId;
    private String name;
    private String surname;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
}
