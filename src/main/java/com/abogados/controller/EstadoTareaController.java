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

import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.service.IEstadoTareaService;

@RestController
@RequestMapping(path = "/estado-tarea")
public class EstadoTareaController {
	
	@Autowired
	private IEstadoTareaService service;
	
	@GetMapping()
	public ResponseEntity<List<EstadoTarea>> listar() throws Exception {
		List<EstadoTarea> estado = service.listar();
		return new ResponseEntity<List<EstadoTarea>>(estado, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody EstadoTarea estado)  throws Exception{
		EstadoTarea validar = new EstadoTarea(estado.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody EstadoTarea estado) throws Exception {
		service.actualizar(estado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoTarea> listarPorId(@PathVariable Integer id) throws Exception{
		EstadoTarea estado = service.listarPorId(id);
		return new ResponseEntity<EstadoTarea>(estado, HttpStatus.OK);
	}
}
