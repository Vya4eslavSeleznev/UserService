package com.info.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ContactUpdateModel {

    private long id;
    private String email;
    private String phone;
}
