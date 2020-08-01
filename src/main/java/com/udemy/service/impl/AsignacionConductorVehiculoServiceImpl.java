package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.AsignacionConductorVehiculo;
import com.udemy.model.AsignacionConductorVehiculoPK;
import com.udemy.repo.IAsignacionConductorVehiculoRepository;
import com.udemy.service.IAsignacionConductorVehiculoService;
import com.udemy.service.common.ServiceCommon;

@Service
public class AsignacionConductorVehiculoServiceImpl extends ServiceCommon<AsignacionConductorVehiculo>
		implements IAsignacionConductorVehiculoService {

	@Autowired
	IAsignacionConductorVehiculoRepository repo;

	public AsignacionConductorVehiculoServiceImpl() {
		base = new AsignacionConductorVehiculo();
	}

	@Override
	public AsignacionConductorVehiculo crear(AsignacionConductorVehiculo t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(AsignacionConductorVehiculo t) {
		try {
			if (base == null)
				return 0;
			base.setEstado(t.isEstado());
			base.setFechaFinalizacionAsignacion(t.getFechaFinalizacionAsignacion());
			repo.save(base);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int eliminar(AsignacionConductorVehiculoPK id) {
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public AsignacionConductorVehiculo listarPorId(AsignacionConductorVehiculoPK id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<AsignacionConductorVehiculo> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<AsignacionConductorVehiculo> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}