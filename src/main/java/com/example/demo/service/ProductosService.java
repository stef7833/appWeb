package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Productos;

public interface ProductosService {
	public abstract Productos addProductos(Productos productos);

	public abstract List<Productos> ListAllProductos();

	public abstract Productos findProductosById(int idproducto);

	public abstract void removeProductos(int idproducto);
	
	public abstract List<Productos> ListProductosActivos();
}
