package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Movimientos;
import com.example.demo.entity.Productos;
import com.example.demo.service.ProductosService;
import com.example.demo.service.MovimientosService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	@Qualifier("productosservice")
	private ProductosService productosService;
	
	@Autowired
	@Qualifier("movimientosservice")
	private MovimientosService movimientosService;
	
	

	@GetMapping("/productsform")
	public String ProductsForm(Model model, @RequestParam(name = "idproducto", required = true) int idproducto) {

		Productos pr = new Productos();

		if (idproducto != 0) {
			pr = productosService.findProductosById(idproducto);
		}

		model.addAttribute("productos", pr);
		return "productsform";

	}

	@PostMapping("/addproductos")
	public String addProductos(@ModelAttribute(name = "productos") @Valid Productos productos, BindingResult result) {

		if (result.hasErrors()) {
			return "productsform";
		}
 
		productosService.addProductos(productos);
		
		
		Movimientos movimientos =new Movimientos();
		movimientos.setIdtipomovimiento(1);
		movimientos.setIdusuario(1);
		movimientos.setIdproducto(productos.getIdproducto());
		movimientos.setCantidad(productos.getExistencia());
		
		movimientosService.addMovimientos(movimientos);
		

		return "redirect:/productos/listadoproducts";
	}

	@GetMapping("/listadoproducts")
	public ModelAndView ListadoProducts() {
		ModelAndView mav = new ModelAndView("products");
		mav.addObject("products", productosService.ListAllProductos());

		return mav;

	}

	@GetMapping("/removeproductos")
	public ModelAndView removeProductos(@RequestParam(name = "idproducto", required = true) int idproducto) {

		productosService.removeProductos(idproducto);

		return ListadoProducts();
	}
	
	
	@GetMapping("/listasalidaproducts") 
	public ModelAndView ListaSalidaProducts() {
		ModelAndView mav = new ModelAndView("productssalida");
		mav.addObject("products", productosService.ListProductosActivos());

		return mav;

	}
	
	
	@GetMapping("/productssalidaform")
	public String ProductsSalidaForm(Model model, @RequestParam(name = "idproducto", required = true) int idproducto) {

		Productos pr = new Productos();

		if (idproducto != 0) {
			pr = productosService.findProductosById(idproducto);
		}

		model.addAttribute("productos", pr);
		return "productssalidaform";

	}
	  
	
	 
	@PostMapping("/disminuirproductos")
	public String disminuirProductos(@ModelAttribute(name = "productos") @Valid Productos productos, BindingResult result) {

		if (result.hasErrors()) {
			return "productssalidaform";
		}
 
		productosService.addProductos(productos);
		
		
		Movimientos movimientos =new Movimientos();
		movimientos.setIdtipomovimiento(2);
		movimientos.setIdusuario(1);
		movimientos.setIdproducto(productos.getIdproducto());
		movimientos.setCantidad(productos.getExistencia());
		
		movimientosService.addMovimientos(movimientos);
		

		return "redirect:/productos/listasalidaproducts";
	} 
	
	@GetMapping("/historico")
	public ModelAndView Historico() {
		ModelAndView mav = new ModelAndView("historico");
		mav.addObject("movements", movimientosService.ListAllMovimientos());

		return mav;

	}

}
