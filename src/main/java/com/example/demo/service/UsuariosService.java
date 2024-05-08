package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Usuarios;

public interface UsuariosService {
	public abstract Usuarios addUsuarios(Usuarios usuarios);
	
	public abstract List<Usuarios> ListAllUsuarios();
	
	public abstract Usuarios findUsuariosById(int idusuario);
	
	public abstract void removeUsuarios(int idusuario);
	
	public abstract Usuarios findUsuariosByNombre(String usuario);
			
}

