package com.abogados.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abogados.model.documentotarea.DocumentoTarea;
import com.abogados.service.IDocumentoTareaService;

@RestController
@RequestMapping(path = "/documento-tarea")
public class DocumentoTareaController {
	
	@Autowired
	private IDocumentoTareaService service;
	
	@GetMapping()
	public ResponseEntity<List<DocumentoTarea>> listar()  throws Exception{
		List<DocumentoTarea> documentoTarea= service.listar();
		return new ResponseEntity<List<DocumentoTarea>>(documentoTarea, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody DocumentoTarea documentoTarea)  throws Exception{
		DocumentoTarea validar = new DocumentoTarea(documentoTarea.getArchivo(), documentoTarea.getTarea());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody DocumentoTarea documentoTarea)  throws Exception{
		service.actualizar(documentoTarea);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/null")
	public ResponseEntity<?> actualizarSinArchivos(@RequestParam String json) throws Exception {
		service.actualizarSinArchivo(json);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DocumentoTarea> listarPorId(@PathVariable Integer id) throws Exception{
		DocumentoTarea documentoTarea = service.listarPorId(id);
		return new ResponseEntity<DocumentoTarea>(documentoTarea, HttpStatus.OK);
	}
	
	@GetMapping(value = "/archivo/{codigo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody byte[] obtenerImagen(@PathVariable Integer codigo) throws IOException {

		return service.obtenerArchivo(codigo);
	}

}
