package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private int idusuario;

	@NotEmpty(message = "Debes ingresar el nombre")
	@Column(name = "nombre")
	private String nombre;

	@NotEmpty(message = "Debes ingresar el correo")
	@Column(name = "correo")
	private String correo;

	@NotEmpty(message = "Debes ingresar la contraseña")
	@Column(name = "contrasena")
	private String contrasena;

	@NotNull(message = "Debes seleccionar el rol")
	@Column(name = "idrol")
	private int idrol;

	@NotNull(message = "Debes seleccionar el estatus")
	@Column(name = "estatus")
	private int estatus;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Usuarios(int idusuario, String nombre, String correo, String contrasena, int idrol, int estatus) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.idrol = idrol;
		this.estatus = estatus;
	}

	public Usuarios() {

	}

}
