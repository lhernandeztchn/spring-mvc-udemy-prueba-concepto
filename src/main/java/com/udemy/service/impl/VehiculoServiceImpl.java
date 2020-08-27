package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Vehiculo;
import com.udemy.repo.IVehiculoRepository;
import com.udemy.service.IVehiculoService;
import com.udemy.service.common.ServiceCommon;

@Service
public class VehiculoServiceImpl extends ServiceCommon<Vehiculo> implements IVehiculoService {

	@Autowired
	IVehiculoRepository repo;

	public VehiculoServiceImpl() {
		base = new Vehiculo();
	}

	@Override
	public Vehiculo crear(Vehiculo t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(Vehiculo t) {
		try {
			base = listarPorId(t.getId());
			if (base == null)
				return 0;

			base.setModelo(t.getModelo());
			base.setTipoVehiculo(t.getTipoVehiculo());
			base.setTransmision(t.getTransmision());
			base.setEstado(t.isEstado());
			base.setUrlImagen(t.getUrlImagen());
			repo.save(base);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int eliminar(Integer id) {
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Vehiculo listarPorId(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Vehiculo> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Vehiculo> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}