package com.test.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Premios;


@Repository
public interface PremiosRepository extends CrudRepository<Premios, Integer> {
	//public Set<Premios> findbynroDocumento(Long codigo);

}
