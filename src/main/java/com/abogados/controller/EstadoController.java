package com.abogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abogados.model.estado.Estado;
import com.abogados.service.IEstadoService;

@RestController
@RequestMapping(path = "/estado")
public class EstadoController {
	
	@Autowired
	private IEstadoService service;
	
	@GetMapping()
	public ResponseEntity<List<Estado>> listar() throws Exception {
		List<Estado> estado = service.listar();
		return new ResponseEntity<List<Estado>>(estado, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Estado estado)  throws Exception{
		Estado validar = new Estado(estado.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Estado estado) throws Exception {
		service.actualizar(estado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estado> listarPorId(@PathVariable Integer id) throws Exception{
		Estado estado = service.listarPorId(id);
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
}
