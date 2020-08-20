package com.udemy.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.Marca;
import com.udemy.model.Modelo;

@Repository
@Transactional
public interface IModeloRepository extends JpaRepository<Modelo, Integer> {
	List<Modelo> findByEstado(boolean estado);

	Optional<Modelo> findByCodigo(String codigo);
	
	Optional<Modelo> findByCodigoAndMarca(String codigo,Marca marca);
}