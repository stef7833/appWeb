package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Usuarios;
import com.example.demo.model.Credenciales;
import com.example.demo.service.UsuariosService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	
	@Autowired
	@Qualifier("usuariosservice") 
	private UsuariosService usuariosService;
	
	
	
	@GetMapping("/")
	public String RedirectLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String Login(Model model,
			@RequestParam(name="error", required = false)String error,
			@RequestParam(name="logout", required = false)String logout) {
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("credenciales", new Credenciales());
		return "login";
	}
	
	@PostMapping("/checar")
	public String Checar(@ModelAttribute(name="credenciales") Credenciales credenciales, HttpSession session) {	
		
		Usuarios us = new Usuarios();
		us=usuariosService.findUsuariosByNombre(credenciales.getNombre());
		
		if(us!=null) {
			if(credenciales.getNombre().equals(us.getNombre()) && credenciales.getContrasena().equals(us.getContrasena())) {
				session.setAttribute("usuario", us);
				session.setAttribute("msg", "Sesion iniciada");

				return "principal";
			}else {
				return "redirect:/login?error";
			}
		}else {
			return "redirect:/login?error";
		}
		
		
		
		
		
		
	}
	
}
