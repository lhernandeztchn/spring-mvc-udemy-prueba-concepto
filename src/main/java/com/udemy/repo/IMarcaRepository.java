package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.Marca;

@Repository
@Transactional
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {
	List<Marca> findByEstado(boolean estado);
}