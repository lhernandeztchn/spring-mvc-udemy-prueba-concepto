package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.TipoVehiculo;

@Repository
@Transactional
public interface ITipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
	List<TipoVehiculo> findByEstado(boolean estado);
}