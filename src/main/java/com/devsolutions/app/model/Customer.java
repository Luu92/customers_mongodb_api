package com.devsolutions.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Customer {

	@Id
	private String id;
	private String nombre; 
	private String noCuenta;
	
	public Customer() {
	} 
	
	public Customer(String id, String nombre, String noCuenta) {
		this.id = id;
		this.nombre = nombre;
		this.noCuenta = noCuenta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	} 
	
	
	
	
	
}
