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

import com.abogados.model.tipotarea.TipoTarea;
import com.abogados.service.ITipoTareaService;

@RestController
@RequestMapping(path = "/tipo-tarea")
public class TipoTareaController {
	
	@Autowired
	private ITipoTareaService service;
	
	@GetMapping()
	public ResponseEntity<List<TipoTarea>> listar()  throws Exception{
		List<TipoTarea> tipoTarea = service.listar();
		return new ResponseEntity<List<TipoTarea>>(tipoTarea, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody TipoTarea tipoTarea) throws Exception {
		TipoTarea validar = new TipoTarea(tipoTarea.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody TipoTarea tipoTarea) throws Exception {
		service.actualizar(tipoTarea);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoTarea> listarPorId(@PathVariable Integer id) throws Exception{
		TipoTarea tipoTarea = service.listarPorId(id);
		return new ResponseEntity<TipoTarea>(tipoTarea, HttpStatus.OK);
	}
	
	
	
}
