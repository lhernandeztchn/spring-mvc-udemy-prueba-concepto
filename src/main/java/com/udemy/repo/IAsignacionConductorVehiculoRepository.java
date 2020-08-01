package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.AsignacionConductorVehiculo;
import com.udemy.model.AsignacionConductorVehiculoPK;

@Repository
@Transactional
public interface IAsignacionConductorVehiculoRepository
		extends JpaRepository<AsignacionConductorVehiculo, AsignacionConductorVehiculoPK> {

	List<AsignacionConductorVehiculo> findByEstado(boolean estado);
	
}