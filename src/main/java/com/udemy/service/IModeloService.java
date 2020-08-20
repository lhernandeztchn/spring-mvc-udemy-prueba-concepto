package com.udemy.service;

import java.util.List;

import com.udemy.model.Modelo;

public interface IModeloService {

	int eliminar(Integer id);

	Modelo getByCodigo(String codigo);

	int agergar(Modelo modelo);

	int eliminarModeloFromList(String codigo);

	List<Modelo> getModelos();

}