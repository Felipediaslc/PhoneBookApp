package com.app.repository;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable>{

	List<Contact> findByActiveSw(String activew);




}
