package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.TipoVehiculo;
import com.udemy.repo.ITipoVehiculoRepository;
import com.udemy.service.ITipoVehiculoService;
import com.udemy.service.common.ServiceCommon;

@Service
public class TipoVehiculoServiceImpl extends ServiceCommon<TipoVehiculo> implements ITipoVehiculoService {

	@Autowired
	ITipoVehiculoRepository repo;

	public TipoVehiculoServiceImpl() {
		base = new TipoVehiculo();
	}

	@Override
	public TipoVehiculo crear(TipoVehiculo t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(TipoVehiculo t) {
		try {
			base = listarPorId(t.getId());
			if (base == null)
				return 0;

			base.setTipoVehiculo(t.getTipoVehiculo());
			base.setEstado(t.isEstado());

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
	public TipoVehiculo listarPorId(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TipoVehiculo> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TipoVehiculo> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}