package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Productos; 

@Repository("productosrepository")
public interface ProductosRepository extends JpaRepository<Productos, Serializable> {
	public abstract Productos findByidproducto(int idproducto);
	
	public abstract List<Productos> findByestatus(int estatus);
}
