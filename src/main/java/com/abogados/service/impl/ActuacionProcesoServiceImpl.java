package com.abogados.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.actuacionproceso.ActuacionProceso;
import com.abogados.model.dto.ActuacionDto;
import com.abogados.repository.actuacionproceso.IActuacionProcesoRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.proceso.IProcesoRepository;
import com.abogados.service.IActuacionProcesoService;
import com.abogados.service.IManejadorArchivo;

@Service
public class ActuacionProcesoServiceImpl extends GeneralServiceImpl<ActuacionProceso, Integer>
		implements IActuacionProcesoService {

	@Autowired
	private IActuacionProcesoRepository repo;
	
	@Autowired
	private IManejadorArchivo manejadorArchivo;
	
	@Value("${ruta.actuacionesProceso}")
	private String rutaActuacionProceso;

	@Value("${ruta}")
	private String rutaArchivo;

	@Autowired
	private IProcesoRepository proRepo;

	protected GeneralRepo<ActuacionProceso, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Integer insertarSinFechas(String json, MultipartFile archivoLlegada) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ActuacionProceso actuacionProceso = objectMapper.readValue(json, ActuacionProceso.class);
		actuacionProceso.setProceso(proRepo.listarPorNumeroProceso(actuacionProceso.getProceso().getNumeroProceso()));
		ActuacionProceso validarActuacion = new ActuacionProceso(actuacionProceso.getActuacion(),
				actuacionProceso.getAnotacion(), actuacionProceso.getArchivo(), actuacionProceso.getProceso());
		validarActuacion.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaActuacionProceso));
		return repo.insertarSinFechas(validarActuacion);
	}
	
	@Override
	public Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		System.err.println(json);
		ActuacionDto actuacionDto = objectMapper.readValue(json, ActuacionDto.class);

		actuacionDto.setProceso(proRepo.listarPorNumeroProceso(actuacionDto.getProceso().getNumeroProceso()));
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//		LocalDateTime fechaHoraInicio = LocalDateTime.parse(actuacionDto.getFechaHoraInicio(), formatter);
//		LocalDateTime fechaHoraFin = LocalDateTime.parse(actuacionDto.getFechaHoraFin(), formatter);
		
		ActuacionProceso validarActuacion = new ActuacionProceso(actuacionDto.getActuacion(),
				actuacionDto.getAnotacion(), actuacionDto.getArchivo(),
				LocalDateTime.parse(actuacionDto.getFechaHoraInicio()), LocalDateTime.parse(actuacionDto.getFechaHoraFin()), actuacionDto.getProceso());

//			Integer resultadoActuacion = repo.insertar(validarActuacion);
//			validarActuacion.setId(resultadoActuacion);

		validarActuacion.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaActuacionProceso));

		return repo.insertar(validarActuacion);
	}
	
	@Override
	public void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		ActuacionProceso actuacionProceso = objectMapper.readValue(json, ActuacionProceso.class);
		ActuacionProceso ActuacionViejo = repo.listarPorId(actuacionProceso.getId());

		try {
			if (!archivoLlegada.isEmpty()) {
				
				actuacionProceso.setArchivo(manejadorArchivo.actualizarArchivo(archivoLlegada, ActuacionViejo.getArchivo(), rutaActuacionProceso));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		repo.actualizar(actuacionProceso);
	}
	
	@Override
	public void eliminarArchivo(Integer id) throws IOException {

		ActuacionProceso actuacionProceso = listarPorId(id);
		manejadorArchivo.eliminarArchivo(actuacionProceso.getArchivo(), rutaActuacionProceso);
		
		repo.eliminar(id);
	
	}
	
	@Override
	public byte[] obtenerArchivo(Integer id) throws IOException {

		ActuacionProceso actuacionProceso = listarPorId(id);

		return manejadorArchivo.obtenerArchivo(rutaActuacionProceso,actuacionProceso.getArchivo());

	}

	@Override
	public void actualizarSinArchivo(String json) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ActuacionProceso actuacionProceso = objectMapper.readValue(json, ActuacionProceso.class);
		repo.actualizarSinArchivo(actuacionProceso);

	}
	
	@Override
	public List<ActuacionProceso> listarPorIdProceso(int id) throws Exception {

		List<ActuacionProceso> listaActuaciones = repo.listarPorIdProceso(id);
		return listaActuaciones;
	}

	@Override
	public List<ActuacionProceso> listarPorNumeroProceso(String numeroProceso) {
		return repo.listarPorNumeroProceso(numeroProceso);
	}

}
