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

import com.example.demo.entity.Usuarios;
import com.example.demo.service.UsuariosService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

		@Autowired
		@Qualifier("usuariosservice") 
		private UsuariosService usuariosService;
		
		
		@GetMapping("/usersform")
		public String UsersForm(Model model,
				@RequestParam(name="idusuario",required=true) int idusuario) {
			
		
			Usuarios us = new Usuarios();
			
			if(idusuario!=0) {
				us=usuariosService.findUsuariosById(idusuario);
			}
			 
			
			model.addAttribute("usuarios", us);
			return "usersform";
			
			
		}
		
		@PostMapping("/addusuarios")
		public String addUsuarios(@ModelAttribute(name="usuarios") @Valid Usuarios usuarios, BindingResult result) {
			
			if(result.hasErrors()) {
				return "usersform";
			}
			
			usuariosService.addUsuarios(usuarios);
			return "redirect:/usuarios/listadousers";
		}
		 
		@GetMapping("/listadousers")
		public ModelAndView ListadoUsers() {
			ModelAndView mav= new ModelAndView("users");
			mav.addObject("users",usuariosService.ListAllUsuarios());
			
			return mav;
			
		}
		
		@GetMapping("/removeusuarios")
		public ModelAndView removeUsuarios(@RequestParam(name="idusuario",required=true) int idusuario) {
			
			usuariosService.removeUsuarios(idusuario);
			
			return ListadoUsers();
		}
		
}
