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

import com.abogados.model.estadoproceso.EstadoProceso;
import com.abogados.service.IEstadoProcesoService;

@RestController
@RequestMapping(path = "/estado-proceso")
public class EstadoProcesoController {
	
	@Autowired
	private IEstadoProcesoService service;
	
	@GetMapping()
	public ResponseEntity<List<EstadoProceso>> listar() throws Exception {
		List<EstadoProceso> estado = service.listar();
		return new ResponseEntity<List<EstadoProceso>>(estado, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody EstadoProceso estado)  throws Exception{
		EstadoProceso validar = new EstadoProceso(estado.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody EstadoProceso estado) throws Exception {
		service.actualizar(estado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoProceso> listarPorId(@PathVariable Integer id) throws Exception{
		EstadoProceso estado = service.listarPorId(id);
		return new ResponseEntity<EstadoProceso>(estado, HttpStatus.OK);
	}
}
