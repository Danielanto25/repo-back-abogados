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

import com.abogados.model.tipocontrato.TipoContrato;
import com.abogados.service.ITipoContratoService;

@RestController
@RequestMapping(path = "/tipo-contrato")
public class TipoContratoController {
	
	@Autowired
	private ITipoContratoService service;
	
	@GetMapping()
	public ResponseEntity<List<TipoContrato>> listar()  throws Exception{
		List<TipoContrato> tipoContrato = service.listar();
		return new ResponseEntity<List<TipoContrato>>(tipoContrato, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody TipoContrato tipoContrato) throws Exception {
		TipoContrato validar = new TipoContrato(tipoContrato.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody TipoContrato tipoContrato) throws Exception {
		service.actualizar(tipoContrato);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoContrato> listarPorId(@PathVariable Integer id) throws Exception{
		TipoContrato tipoContrato = service.listarPorId(id);
		return new ResponseEntity<TipoContrato>(tipoContrato, HttpStatus.OK);
	}
	
	
	

}
