package com.info.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactUpdateModel {

    private long id;
    private String email;
    private String phone;
}
