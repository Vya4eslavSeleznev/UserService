package com.info.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindCustomerModel {

    private long id;
    private String name;
    private String surname;
    private String lastName;
    private String username;
    private String email;
    private String phone;
}
