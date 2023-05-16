package com.info.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public Customer(String name, String surname, String lastName, Contact contact, Credential credential,
                    Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.contact = contact;
        this.credential = credential;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "credential_id")
    private Credential credential;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
}
