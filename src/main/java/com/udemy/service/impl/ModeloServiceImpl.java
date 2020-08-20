package com.udemy.service.impl;

import java.util.ArrayList;
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

	private List<Modelo> modelos;

	public ModeloServiceImpl() {
		modelos = new ArrayList<Modelo>();
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
	public int eliminarModeloFromList(String codigo) {
		if (modelos.removeIf(modelo -> modelo.getCodigo() == codigo))
			return 1;
		return -1;
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
	public int agergar(Modelo modelo) {
		try {
			modelos.add(modelo);
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Modelo> getModelos() {
		return modelos;
	}
}