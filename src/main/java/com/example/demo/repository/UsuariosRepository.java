package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuarios;

@Repository("usuariosrepository")
public interface UsuariosRepository extends JpaRepository<Usuarios, Serializable>{
	
	public abstract Usuarios findByidusuario(int idusuario);
	
	public abstract Usuarios findBynombre(String nombre);
	
}
