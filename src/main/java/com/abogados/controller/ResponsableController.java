package com.abogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abogados.model.responsable.Responsable;
import com.abogados.service.IResponsableService;

@RestController
@RequestMapping(path = "/responsable")
public class ResponsableController {

	@Autowired
	private IResponsableService service;

	@GetMapping()
	public ResponseEntity<List<Responsable>> listar() throws Exception {
		List<Responsable> responsables = service.listar();
		return new ResponseEntity<List<Responsable>>(responsables, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Responsable>> listarPorIdAgendarTarea(@PathVariable Integer id) throws Exception {
		List<Responsable> responsables = service.listarPorIdAgendarTarea(id);
		return new ResponseEntity<List<Responsable>>(responsables, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Responsable responsable) throws Exception {
		Responsable validar = new Responsable(responsable.getUsuario(), responsable.getAgendarTarea());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Responsable responsable)  throws Exception{
		service.actualizar(responsable);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
