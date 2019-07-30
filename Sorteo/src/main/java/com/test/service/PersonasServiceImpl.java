package com.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Personas;
import com.test.repository.PersonasRepository;

@Service
public class PersonasServiceImpl implements PersonasService {

	@Autowired
	PersonasRepository repository;
	
	@Override
	public Iterable<Personas> getAllPersonas() {
		
		return repository.findAll();
	}

	
	
	private boolean checknombreexiste(Personas Personas) throws Exception {
		
		Optional<Personas> PersonasFound = repository.findbynombres(Personas.getNombres());
		if (PersonasFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
		
	}
	
      private boolean checkdocumentoexiste(Personas Personas) throws Exception {
		
		Optional<Personas> PersonasFound = repository.findbynroDocumento(Personas.getNroDocumento());
		if (PersonasFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
		
	}
	
      
      public Personas CreatePersonas(Personas Personas) throws Exception {
  		if (checknombreexiste(Personas) && checkdocumentoexiste(Personas)) {
  			Personas = repository.save(Personas);
  		}
  		return Personas;
  	}



	public void deletePersonas(Long id) throws Exception {
		Personas Personas = PersonasService.findById(id)
				.orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));

		repository.delete(Personas);
		
	}
}


