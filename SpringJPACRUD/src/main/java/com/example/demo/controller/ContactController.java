package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService crservice;

	@RequestMapping(value = "/all", method = RequestMethod.GET)

	public List<Contact> findAll() {
		return crservice.findAll();

	}

	@RequestMapping("/contact/{contact_id}")
	public Contact findContactById(@PathVariable("contact_id") Integer contact_id) {
		return crservice.findById(contact_id);

	}

	@RequestMapping(value = "/contact/insert", method = RequestMethod.POST)
	public String addContact(@RequestParam int contact_id, @RequestParam String name, @RequestParam String address,
			@RequestParam String email, @RequestParam String telephone) {
		Contact contact = new Contact(contact_id, name, address, email, telephone);
		crservice.save(contact);
		return "Contact Saved";
	}

	@RequestMapping(value = "/contact/{contact_id}", method = RequestMethod.DELETE)
	public void delContact(@PathVariable("contact_id") int contact_id) {
		crservice.delete(contact_id);
	}

}
