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

import com.abogados.model.demandante.Demandante;
import com.abogados.service.IDemandanteService;

@RestController
@RequestMapping(path = "/demandante")
public class DemandanteController {
	
	@Autowired
	private IDemandanteService service;

	@GetMapping()
	public ResponseEntity<List<Demandante>> listar() throws Exception {
		List<Demandante> proceso = service.listar();
		return new ResponseEntity<List<Demandante>>(proceso, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Demandante demandante)  throws Exception{
		Demandante validar = new Demandante(demandante.getDemandante(), demandante.getDocDemandante(), demandante.getProceso());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Demandante demandante) throws Exception {
		service.actualizar(demandante);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Demandante> listarPorId(@PathVariable Integer id) throws Exception{
		Demandante demandante = service.listarPorId(id);
		return new ResponseEntity<Demandante>(demandante, HttpStatus.OK);
	}
	
	@GetMapping("/listarProceso/{id}")
	public ResponseEntity<List<Demandante>> listarProcesoDemante(@PathVariable Integer id) throws Exception{
		List<Demandante> demandante = service.listarProcesoDemandante(id);
		return new ResponseEntity<List<Demandante>>(demandante, HttpStatus.OK);
	}

}
