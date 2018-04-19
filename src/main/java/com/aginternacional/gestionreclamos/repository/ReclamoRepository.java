package com.aginternacional.gestionreclamos.repository;

import com.aginternacional.gestionreclamos.domain.Reclamo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends CrudRepository<Reclamo, Integer>{

}
