package com.info.user.controller;

import com.info.user.entity.Contact;
import com.info.user.service.ContactService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Contact> findById(@PathVariable long id) {
        return new ResponseEntity<>(contactService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Contact>> findAll() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }
}
