package com.test.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Personas;

@Repository
public interface PersonasRepository extends CrudRepository<Personas, Integer>{

public Optional<Personas> findbynombres(String nombres);

public Optional<Personas> findbynroDocumento(Long nroDocumento);
}
