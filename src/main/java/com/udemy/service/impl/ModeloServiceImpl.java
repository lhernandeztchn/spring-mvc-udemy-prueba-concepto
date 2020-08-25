package com.udemy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.model.Modelo;
import com.udemy.repo.IModeloRepository;
import com.udemy.repo.crude.IModeloCrudeRespository;
import com.udemy.service.IModeloService;
import com.udemy.service.common.ServiceCommon;

@Service
public class ModeloServiceImpl extends ServiceCommon<Modelo> implements IModeloService {

	@Autowired
	IModeloRepository repo;

	@Autowired
	IModeloCrudeRespository crudeRepo;

	@Override
	public int eliminar(Integer id) {
		try {

			if (GetById(id) == null)
				return 0;

			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Modelo getByCodigo(String codigo) {
		try {
			object = repo.findByCodigo(codigo);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int currentId() {
		return crudeRepo.max();
	}

	private Modelo GetById(Integer id) {
		try {
			object = repo.findById(id);
			return object.isPresent() == true ? object.get() : null;
		} catch (Exception e) {
			throw e;
		}
	}
}