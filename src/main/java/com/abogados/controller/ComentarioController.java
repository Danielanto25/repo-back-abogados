package com.abogados.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.abogados.model.comentario.Comentario;
import com.abogados.service.IComentarioService;
import com.abogados.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(path = "/comentario")
public class ComentarioController {
	
	@Autowired
	private IComentarioService service;
	
	@Autowired
	private UsuarioServiceImpl usuService;
	
	@GetMapping()
	public ResponseEntity<List<Comentario>> listar()  throws Exception{
		List<Comentario> comentario = service.listar();
		return new ResponseEntity<List<Comentario>>(comentario, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Comentario comentario, HttpServletRequest request)  throws Exception{
		System.out.println(comentario);
		Comentario validar = new Comentario(comentario.getTexto(), usuService.info(request), comentario.getTarea());
		Integer resultado = service.insertar(validar);
		System.out.println(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Comentario comentario)  throws Exception{
		service.actualizar(comentario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*@GetMapping("/{id}")
	public ResponseEntity<Comentario> listarPorId(@PathVariable Integer id) throws Exception{
		Comentario comentario = service.listarPorId(id);
		return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Comentario>> listarPorIdComentario(@PathVariable Integer id)  throws Exception{
		List<Comentario> comentario = service.listarPorIdComentario(id);
		return new ResponseEntity<List<Comentario>>(comentario, HttpStatus.OK);
	}

}
