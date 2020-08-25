package com.udemy.repo.crude;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.model.Modelo;

@Repository
public interface IModeloCrudeRespository extends CrudRepository<Modelo, Integer> {

	@Query(value = "SELECT max(id) FROM Modelo")
	public Integer max();
}