package com.example.demo.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository crp;

	public List<Contact> findAll() {
		return crp.findAll();

	}

	public void save(Contact contact) {
		crp.save(contact);
	}

	public void delete(int contact_id) {
		crp.delete(contact_id);
	}

	public Contact findById(int contact_id) {
		return crp.findOne(contact_id);
	}

}
