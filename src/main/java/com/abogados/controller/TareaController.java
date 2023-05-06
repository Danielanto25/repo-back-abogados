package com.abogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.tarea.Tarea;
import com.abogados.service.IDocumentoTareaService;
import com.abogados.service.ITareaService;

@RestController
@RequestMapping(path = "/tarea")
public class TareaController {
	
	@Autowired
	private ITareaService service;
	
	@Autowired
	private IDocumentoTareaService docTarService;
	
	@GetMapping()
	public ResponseEntity<List<Tarea>> listar()  throws Exception{
		List<Tarea> tarea = service.listar();
		return new ResponseEntity<List<Tarea>>(tarea, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestParam String json, @RequestPart MultipartFile archivoLlegada, @RequestParam String responsable)  throws Exception{
		
		System.out.println(responsable);
		Integer resultado = docTarService.subirArchivo(json,archivoLlegada, responsable);

		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
		

	}
	
	@PostMapping("/varios")
	public ResponseEntity<?> insertarVariosResponsables(@RequestParam String json, @RequestPart MultipartFile archivoLlegada, @RequestParam String responsable)  throws Exception{
		
		Integer resultado = docTarService.insertarVariosResponsables(json,archivoLlegada, responsable);

		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
		
	}
	

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestParam String json, @RequestPart MultipartFile archivoLlegada) throws Exception {
		docTarService.subirArchivoEditar(json,archivoLlegada);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}*/
	
	@PutMapping("/null")
	public ResponseEntity<?> actualizarSinArchivos(@RequestParam String json) throws Exception {
		service.actualizar(json);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> pasarReporte(@PathVariable Integer id, @RequestParam String idReporte)  throws Exception{
		System.out.println(idReporte);
		Integer prueba = Integer.parseInt(idReporte);
		System.out.println(prueba);
		service.pasarReporte(id, prueba );

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
