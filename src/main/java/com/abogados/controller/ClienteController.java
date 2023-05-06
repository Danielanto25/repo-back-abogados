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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.cliente.Cliente;
import com.abogados.service.IClienteService;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	

	@GetMapping()
	public ResponseEntity<List<Cliente>> listar()  throws Exception{
		List<Cliente> cliente = service.listar();
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestParam String json, @RequestPart MultipartFile archivoLlegada)  throws Exception{
		
		Integer resultado = service.subirArchivo(json, archivoLlegada);
		
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestParam String json, @RequestPart MultipartFile archivoLlegada)  throws Exception{
		service.actualizarArchivo(json, archivoLlegada);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) throws Exception {
		service.eliminarArchivo(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable Integer id) throws Exception{
		Cliente cliente = service.listarPorId(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	@GetMapping("cliente/{cliente}")
	public ResponseEntity<Cliente> listarPorCliente(@PathVariable String cliente) throws Exception{
		Cliente bibliotecaDocumento = service.listarPorCliente(cliente);
		return new ResponseEntity<Cliente>(bibliotecaDocumento, HttpStatus.OK);
	}
	
	@PutMapping("/null")
	public ResponseEntity<?> actualizarSinArchivos(@RequestParam String json) throws Exception {
		service.actualizarSinArchivo(json);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/archivo/{codigo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody byte[] obtenerImagen(@PathVariable Integer codigo) throws IOException {

		return service.obtenerArchivo(codigo);
	}

}
