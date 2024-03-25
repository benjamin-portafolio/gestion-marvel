package com.openpay.gestionmarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpay.gestionmarvel.service.GestionMarvelService;

@RestController
@CrossOrigin
public class GestionMarvelController {
	
	@Autowired
	private GestionMarvelService service;
	
	@GetMapping(value="/")
	public String prueba() {
		return service.Test();
	}

}
