package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Modelo;
import com.udemy.repo.IModeloRepository;
import com.udemy.service.IModeloService;
import com.udemy.service.common.ServiceCommon;

@Service
public class ModeloServiceImpl extends ServiceCommon<Modelo> implements IModeloService {

	@Autowired
	IModeloRepository repo;

	public ModeloServiceImpl() {
		base = new Modelo();
	}

	@Override
	public Modelo crear(Modelo t) {
		try { 
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(Modelo t) {
		try {
			base = listarPorId(t.getId());
			if (base == null)
				return 0;

			base.setMarca(t.getMarca());
			base.setModelo(t.getModelo());
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
	public Modelo listarPorId(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Modelo> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Modelo> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}