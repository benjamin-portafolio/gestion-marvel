package com.openpay.gestionmarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.gestionmarvel.model.Usuario;
import com.openpay.gestionmarvel.service.GestionMarvelService;
import com.google.gson.Gson;

@RestController
@CrossOrigin
@EnableJpaRepositories
public class GestionMarvelController {
	
	@Autowired
	private GestionMarvelService service;
	
	@GetMapping(value="/")
	public String prueba() {
		return service.Test();
	}
	
	@GetMapping(value="/json")
	public ObjetoPrueba pruebaJson() {
		String cadenaJson="{\"primerAtributo\":\"texto desde cadena \",\"segundoAtributo\":11,\"tercerAtributo\":\"prueba\"}";
		System.out.println(cadenaJson);
		System.out.println(service.Test());
		Gson gson = new Gson();
		ObjetoPrueba objPrueba = gson.fromJson(cadenaJson, ObjetoPrueba.class);
		
		
//		objPrueba.setPrimerAtributo("texto de prueba");
//		objPrueba.setSegundoAtributo(123);
		return objPrueba;
	}
	
	@GetMapping(value="/getCharactersById")
	public String getrCharactersById() {
		return service.pruebaCharacters();
	}
	
	@PostMapping(value="/crearUsuario")
	public Usuario crearUsuario(@RequestBody  Usuario usuario) {
		return service.createUsuario(usuario);
	}

}
