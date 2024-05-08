package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movimientos;
import com.example.demo.repository.MovimientosRepository;
import com.example.demo.service.MovimientosService;
 
@Service("movimientosservice")
public class MovimientosServiceImpl  implements MovimientosService {

	
	@Autowired 
	@Qualifier("movimientosrepository") 
	private MovimientosRepository movimientosRepository;
	
	
	@Override
	public Movimientos addMovimientos(Movimientos movimientos) {
		return movimientosRepository.save(movimientos);
	}
 

	@Override
	public List<Movimientos> ListAllMovimientos() {
		List<Movimientos> movimientos = new ArrayList<>();

		movimientos = movimientosRepository.findAll();

		return movimientos;
	}

}
