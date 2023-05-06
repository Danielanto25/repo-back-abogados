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

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;
import com.abogados.service.IAgendarTareaService;

@RestController
@RequestMapping(path = "/agendar-tarea")
public class AgendarTareaController {

	@Autowired
	private IAgendarTareaService service;

	@GetMapping()
	public ResponseEntity<List<AgendarTarea>> listar() throws Exception {
		List<AgendarTarea> agendarTarea = service.listar();
		return new ResponseEntity<List<AgendarTarea>>(agendarTarea, HttpStatus.OK);
	}
	
	@GetMapping("dto")
	public ResponseEntity<List<AgendarTareaDto>> listarDto() throws Exception {
		List<AgendarTareaDto> agendarTarea = service.listarDto();
		return new ResponseEntity<List<AgendarTareaDto>>(agendarTarea, HttpStatus.OK);
	}
	
	@GetMapping("/listarUser/{user}")
	public ResponseEntity<List<AgendarTareaDto>> listarUser(@PathVariable String user) throws Exception {
		List<AgendarTareaDto> agendarTarea = service.listarUser(user);
		return new ResponseEntity<List<AgendarTareaDto>>(agendarTarea, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody AgendarTarea agendarTarea) throws Exception {
		AgendarTarea validar = new AgendarTarea(agendarTarea.getFechaHoraInicio(), agendarTarea.getFechaHoraFin(), agendarTarea.getEstado(), agendarTarea.getTarea());
		Integer resultado = service.insertar(validar);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody AgendarTarea agendarTarea)  throws Exception{
		service.actualizar(agendarTarea);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AgendarTarea> listarTarea(@PathVariable Integer id)  throws Exception{
		AgendarTarea agendarTarea = service.listarTarea(id);
		return new ResponseEntity<AgendarTarea>(agendarTarea, HttpStatus.OK);
	}
	
	@GetMapping("fechaInicio/{fechaInicio}")
	public ResponseEntity<List<AgendarTarea>> listarPorFechaInicio(@PathVariable String fechaInicio) throws Exception{
		List<AgendarTarea> agendarTarea = service.listarPorFechaInicio(fechaInicio);
		return new ResponseEntity<List<AgendarTarea>>(agendarTarea, HttpStatus.OK);
	}
	
	@GetMapping("fechaFin/{fechaFin}")
	public ResponseEntity<List<AgendarTarea>> listarPorFechaFin(@PathVariable String fechaFin) throws Exception{
		System.out.print(fechaFin);
		List<AgendarTarea> agendarTarea = service.listarPorFechaFin(fechaFin);
		return new ResponseEntity<List<AgendarTarea>>(agendarTarea, HttpStatus.OK);
	}

}
