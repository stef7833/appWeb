package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "movimientos")
public class Movimientos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovimiento")
	private int idmovimiento;

	@Column(name = "idtipomovimiento")
	private int idtipomovimiento;
	
	@Column(name = "idusuario")
	private int idusuario;
	
	@Column(name = "idproducto")
	private int idproducto;
	
	@Column(name = "fecha_hora")
	private Timestamp  fecha_hora;
	
	@Column(name = "cantidad")
	private int cantidad;

	public int getIdmovimiento() {
		return idmovimiento;
	}

	public void setIdmovimiento(int idmovimiento) {
		this.idmovimiento = idmovimiento;
	}

	public int getIdtipomovimiento() {
		return idtipomovimiento;
	}

	public void setIdtipomovimiento(int idtipomovimiento) {
		this.idtipomovimiento = idtipomovimiento;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public Timestamp getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Movimientos(int idmovimiento, int idtipomovimiento, int idusuario, int idproducto, Timestamp fecha_hora,
			int cantidad) {
		super();
		this.idmovimiento = idmovimiento;
		this.idtipomovimiento = idtipomovimiento;
		this.idusuario = idusuario;
		this.idproducto = idproducto;
		this.fecha_hora = fecha_hora;
		this.cantidad = cantidad;
	}
	
	public Movimientos() {
		
	}
	
}
