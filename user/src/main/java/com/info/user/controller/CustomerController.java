package com.info.user.controller;

import com.info.user.model.CustomerSaveModel;
import com.info.user.model.CustomerUpdateModel;
import com.info.user.model.FindCustomerModel;
import com.info.user.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<FindCustomerModel> findById(@PathVariable long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> save(@RequestBody CustomerSaveModel customerSaveModel) {
        customerService.save(customerSaveModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<FindCustomerModel>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> update(@RequestBody CustomerUpdateModel customerUpdateModel) {
        customerService.update(customerUpdateModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
