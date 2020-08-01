package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Conductor;
import com.udemy.repo.IConductorRepository;
import com.udemy.service.IConductorService;
import com.udemy.service.common.ServiceCommon;

@Service
public class ConductorServiceImpl extends ServiceCommon<Conductor> implements IConductorService {

	@Autowired
	IConductorRepository repo;

	public ConductorServiceImpl() {
		base = new Conductor();
	}

	@Override
	public Conductor crear(Conductor t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(Conductor t) {
		try {
			base = listarPorId(t.getDni());
			if (base == null)
				return 0;

			base.setNombreCompleto(t.getNombreCompleto());
			base.setTelefono(t.getTelefono());
			base.setCorreoElectronico(t.getCorreoElectronico());
			base.setEstado(t.isEstado());
			base.setFecha_nacimiento(t.getFecha_nacimiento());

			repo.save(base);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int eliminar(String id) {
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Conductor listarPorId(String id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Conductor> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Conductor> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}