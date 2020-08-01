package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Marca;
import com.udemy.repo.IMarcaRepository;
import com.udemy.service.IMarcaService;
import com.udemy.service.common.ServiceCommon;

@Service
public class MarcaServiceImpl extends ServiceCommon<Marca> implements IMarcaService {

	@Autowired
	IMarcaRepository repo;

	public MarcaServiceImpl() {
		base = new Marca();
	}

	@Override
	public Marca crear(Marca t) {
		try {
			return repo.saveAndFlush(t);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int modificar(Marca t) {
		try {
			base = listarPorId(t.getId());
			if (base == null)
				return 0;

			base.setMarca(t.getMarca());
			base.setEstado(t.isEstado());
			base.setModelos(t.getModelos());
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
	public Marca listarPorId(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Marca> listar() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Marca> listarPorEstado(boolean estado) {
		try {
			return repo.findByEstado(estado);
		} catch (Exception e) {
			throw e;
		}
	}
}