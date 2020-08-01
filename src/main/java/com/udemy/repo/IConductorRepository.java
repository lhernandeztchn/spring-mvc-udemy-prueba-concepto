package com.udemy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.model.Conductor;

@Repository
@Transactional
public interface IConductorRepository extends JpaRepository<Conductor, String> {
	List<Conductor> findByEstado(boolean estado);
}