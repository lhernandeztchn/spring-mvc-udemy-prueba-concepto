package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Viajes;
import com.udemy.repo.IViajesRepository;
import com.udemy.service.IViajesService;
import com.udemy.service.common.ServiceCommon;

@Service
public class ViajesServiceImpl extends ServiceCommon<Viajes> implements IViajesService {

	@Autowired
	IViajesRepository repo;

	public ViajesServiceImpl() {
		base = new Viajes();
	}

	@Override
	public Viajes crear(Viajes t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(Viajes t) {
		try {
			base = listarPorId(t.getId());
			if (base == null)
				return 0;
			base.setConductorVehiculo(t.getConductorVehiculo());
			base.setEstado(t.isEstado());
			base.setEstadoViaje(t.getEstadoViaje());
			base.setFechaSalida(t.getFechaSalida());
			base.setFechaRetorno(t.getFechaRetorno());
			base.setMotivo(t.getMotivo());
		
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
	public Viajes listarPorId(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Viajes> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Viajes> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}