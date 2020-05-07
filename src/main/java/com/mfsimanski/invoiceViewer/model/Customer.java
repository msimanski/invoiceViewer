package com.mfsimanski.invoiceViewer.model;
// Generated May 6, 2020, 12:08:22 PM by Hibernate Tools 5.4.14.Final

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int customerId;
	
	public String firstName;
	public String lastName;
	public String phone;
	public String email;
	
	@OneToMany(mappedBy = "customer", targetEntity = Invoice.class)
	public Set<Invoice> invoices;

	public Customer(int customerId, String firstName, String lastName, String phone, String email,
			Set<Invoice> invoices)
	{
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.invoices = invoices;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Set<Invoice> getInvoices()
	{
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices)
	{
		this.invoices = invoices;
	}
}