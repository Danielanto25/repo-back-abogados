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

import com.abogados.model.proceso.Proceso;
import com.abogados.model.proceso.ProcesoDto;
import com.abogados.service.IProcesoService;

@RestController
@RequestMapping(path = "/proceso")
public class ProcesoController {

	@Autowired
	private IProcesoService service;

	@GetMapping()
	public ResponseEntity<List<Proceso>> listar() throws Exception {
		List<Proceso> proceso = service.listar();
		return new ResponseEntity<List<Proceso>>(proceso, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody ProcesoDto proceso)  throws Exception{
//		Proceso validar = new Proceso(proceso.getNumeroProceso(), proceso.getCorporacion(), proceso.getCiudad(), proceso.getDespacho(), proceso.getPonente(), proceso.getCuantia(), proceso.getTipoProceso(), proceso.getEstado());
		service.insertar(proceso);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody ProcesoDto proceso) throws Exception {
		service.actualizarCompleto(proceso);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id)  throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/numero-proceso/{numeroProceso}")
	public ResponseEntity<Proceso> listarPorNumeroProceso(@PathVariable String numeroProceso)  throws Exception{
		Proceso proceso = service.listarPorNumeroProceso(numeroProceso);
		return new ResponseEntity<Proceso>(proceso, HttpStatus.OK);
	}
	
	@GetMapping("/cliente/")
	public ResponseEntity<List<ProcesoDto>> listarProcesosPorCliente(HttpServletRequest req)  throws Exception{
		List<ProcesoDto> procesos = service.listarProcesoCliente(req);
		return new ResponseEntity<List<ProcesoDto>>(procesos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcesoDto> listarPorId2(@PathVariable Integer id) throws Exception{
		ProcesoDto proceso = service.listarPorId2(id);
		return new ResponseEntity<ProcesoDto>(proceso, HttpStatus.OK);
	}
	
	@GetMapping("dto")
	public ResponseEntity<List<ProcesoDto>> listarDto() throws Exception{
		List<ProcesoDto> proceso = service.listarDto();
		return new ResponseEntity<List<ProcesoDto>>(proceso, HttpStatus.OK);
	}
	
	@GetMapping("radicado/{radicado}")
	public ResponseEntity<List<ProcesoDto>> listarPorRadicado(@PathVariable String radicado) throws Exception{
		List<ProcesoDto> Procesos = service.listarPorRadicado(radicado);
		return new ResponseEntity<List<ProcesoDto>>(Procesos, HttpStatus.OK);
	}
	
	@GetMapping("despacho/{despacho}")
	public ResponseEntity<List<ProcesoDto>> listarPorDespacho(@PathVariable String despacho) throws Exception{
		List<ProcesoDto> Procesos = service.listarPorDespacho(despacho);
		return new ResponseEntity<List<ProcesoDto>>(Procesos, HttpStatus.OK);
	}
	
	@GetMapping("demandante/{demandante}")
	public ResponseEntity<List<ProcesoDto>> listarPorDemandante(@PathVariable String demandante) throws Exception{
		List<ProcesoDto> Procesos = service.listarPorDemandante(demandante);
		return new ResponseEntity<List<ProcesoDto>>(Procesos, HttpStatus.OK);
	}
	@GetMapping("demandado/{demandado}")
	public ResponseEntity<List<ProcesoDto>> listarPorDemandado(@PathVariable String demandado) throws Exception{
		List<ProcesoDto> Procesos = service.listarPorDemandado(demandado);
		return new ResponseEntity<List<ProcesoDto>>(Procesos, HttpStatus.OK);
	}
}