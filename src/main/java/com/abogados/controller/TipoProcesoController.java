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

import com.abogados.model.tipoproceso.TipoProceso;
import com.abogados.service.ITipoProcesoService;

@RestController
@RequestMapping(path = "/tipo-proceso")
public class TipoProcesoController {
	
	@Autowired
	private ITipoProcesoService service;
	
	@GetMapping()
	public ResponseEntity<List<TipoProceso>> listar() throws Exception {
		List<TipoProceso> tipoProceso = service.listar();
		return new ResponseEntity<List<TipoProceso>>(tipoProceso, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody TipoProceso tipoProceso) throws Exception {
		TipoProceso validar = new TipoProceso(tipoProceso.getNombre());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody TipoProceso tipoProceso) throws Exception {
		service.actualizar(tipoProceso);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoProceso> listarPorId(@PathVariable Integer id) throws Exception{
		TipoProceso tipoProceso = service.listarPorId(id);
		return new ResponseEntity<TipoProceso>(tipoProceso, HttpStatus.OK);
	}
	
	
	
}
