package com.jaga.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaga.pojo.Customer;


@Component
@Path("/xml/customer")
public class XMLService {
	
	@Autowired
	Customer customer;
	
	@GET
	@Path("/{pin}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerInXML(@PathParam("pin") int pin) {
 
		System.out.println("pin:-"+pin);
		customer.setName("jaga");
		customer.setPin(pin);
		System.out.println("customer pin:-"+customer.getPin());
		return customer;
 
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createCustomerInXML(Customer customer) {
 
		String result = "customer saved : " + customer;
		
	//	System.out.println("singer:"+track.getSinger());
		//System.out.println("title:"+track.getTitle());
		return Response.status(201).entity(result).build();
 
	}
 
}