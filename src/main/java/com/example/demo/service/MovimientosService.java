package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movimientos;


public interface MovimientosService {
	public abstract Movimientos addMovimientos(Movimientos movimientos);
	
	public abstract List<Movimientos> ListAllMovimientos();
	
	
}
