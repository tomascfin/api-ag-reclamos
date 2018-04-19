package com.aginternacional.gestionreclamos.repository;

import com.aginternacional.gestionreclamos.domain.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer>{
}
