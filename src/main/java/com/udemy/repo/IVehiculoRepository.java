package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.Vehiculo;

@Repository
@Transactional
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {
	List<Vehiculo> findByEstado(boolean estado);
}