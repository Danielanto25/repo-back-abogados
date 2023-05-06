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

import com.abogados.model.demandado.Demandado;
import com.abogados.service.IDemandadoService;

@RestController
@RequestMapping(path = "/demandado")
public class DemandadoController {
	
	@Autowired
	private IDemandadoService service;

	@GetMapping()
	public ResponseEntity<List<Demandado>> listar() throws Exception {
		List<Demandado> proceso = service.listar();
		return new ResponseEntity<List<Demandado>>(proceso, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Demandado demandado)  throws Exception{
		Demandado validar = new Demandado(demandado.getDemandado(), demandado.getDocDemandado(), demandado.getProceso());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Demandado demandado) throws Exception {
		service.actualizar(demandado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Demandado> listarPorId(@PathVariable Integer id) throws Exception{
		Demandado demandado = service.listarPorId(id);
		return new ResponseEntity<Demandado>(demandado, HttpStatus.OK);
	}
	
	@GetMapping("/listarProceso/{id}")
	public ResponseEntity<List<Demandado>> listarProcesoDemandado(@PathVariable Integer id) throws Exception{
		List<Demandado> demandado = service.listarProcesoDemandado(id);
		return new ResponseEntity<List<Demandado>>(demandado, HttpStatus.OK);
	}
	

}
