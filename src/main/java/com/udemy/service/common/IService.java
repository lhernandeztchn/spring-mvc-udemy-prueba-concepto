package com.udemy.service.common;

import java.util.List;

public interface IService<T, ID> {

	T crear(T t);
	
	int modificar(T t);
	
	int eliminar(ID id);

	T listarPorId(ID id);

	List<T> listar();

	List<T> listarPorEstado(boolean estado);

}