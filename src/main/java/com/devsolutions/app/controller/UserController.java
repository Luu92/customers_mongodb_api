package com.devsolutions.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsolutions.app.model.Customer;
import com.devsolutions.app.model.repository.ICustomerRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	 @Autowired
	 private ICustomerRepository customerRepository;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
		try {
			Customer newCustomer = customerRepository.save(customer);
			return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") String id){
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Existe Usuario con ese registro", HttpStatus.NOT_FOUND);
        }

	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		try {
            // Verificar si el customer existe en la base de datos
            if (customer.getId() == null || customerRepository.existsById(customer.getId())) {
                Customer updatedCustomer = customerRepository.save(customer);
                return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No existe el usuario con ese ID", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") String id){
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.deleteById(id);
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Existe Usuario con ese registro", HttpStatus.NOT_FOUND);
        }
	}
	

}
