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
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private int idproducto;

	@NotEmpty(message = "Debes ingresar el nombre")
	@Column(name = "nombre")
	private String nombre;

	@NotNull(message = "Debes ingresar el precio")
	@Column(name = "precio")
	private double precio;

	@Column(name = "existencia")
	private int existencia;

	@NotNull(message = "Debes seleccionar el estatus")
	@Column(name = "estatus")
	private int estatus;

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Productos(int idproducto, @NotEmpty(message = "Debes ingresar el nombre") String nombre,
			@NotEmpty(message = "Debes ingresar el precio") double precio, int existencia,
			@NotNull(message = "Debes seleccionar el estatus") int estatus) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.existencia = existencia;
		this.estatus = estatus;
	}

	public Productos() {

	}

}
