package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Productos;
import com.example.demo.repository.ProductosRepository;
import com.example.demo.service.ProductosService;

@Service("productosservice")
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	@Qualifier("productosrepository")
	private ProductosRepository productosRepository;

	@Override
	public Productos addProductos(Productos productos) {
		return productosRepository.save(productos);
	}

	@Override
	public List<Productos> ListAllProductos() {
		List<Productos> products = new ArrayList<>();

		products = productosRepository.findAll();

		return products;
	}

	@Override
	public Productos findProductosById(int idproducto) {
		return productosRepository.findByidproducto(idproducto);
	}

	@Override
	public void removeProductos(int idproducto) {
		Productos pr = findProductosById(idproducto);
 
		if (null != pr) {
			int estatus=pr.getEstatus();
			pr.setEstatus(estatus==1?2:1);
			productosRepository.save(pr);

		}

	}

	@Override
	public List<Productos> ListProductosActivos() {
		List<Productos> products = new ArrayList<>();

		products = productosRepository.findByestatus(1);

		return products;
	}  

}
