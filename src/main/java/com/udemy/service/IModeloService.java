package com.udemy.service;


import com.udemy.model.Modelo;

public interface IModeloService {

	int eliminar(Integer id);

	Modelo getByCodigo(String codigo);
	
	int currentId();

}