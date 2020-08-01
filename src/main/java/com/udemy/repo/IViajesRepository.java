package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.Viajes;

@Repository
@Transactional
public interface IViajesRepository extends JpaRepository<Viajes, Integer> {
	List<Viajes> findByEstado(boolean estado);
}