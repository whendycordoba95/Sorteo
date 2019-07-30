package com.test.service;

import java.util.Optional;

import javax.validation.Valid;

import com.test.entity.Personas;

public interface PersonasService {
	
	public  Iterable<Personas> getAllPersonas();

	public static void createPersonas(@Valid Personas personas) {
				
	}
	public static void deletePersonas(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public static Optional<Personas> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
