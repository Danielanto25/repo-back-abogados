package com.abogados.service.impl;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.documentotarea.DocumentoTarea;
import com.abogados.model.dto.ResponsablesMultiplesDto;
import com.abogados.model.dto.TareaDto;
import com.abogados.model.responsable.Responsable;
import com.abogados.model.tarea.Tarea;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.agendartarea.IAgendarTareaRepository;
import com.abogados.repository.documentotarea.IDocumentoTareaRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.responsable.IResponsableRepository;
import com.abogados.repository.tarea.ITareaRepository;
import com.abogados.service.IDocumentoTareaService;
import com.abogados.service.IManejadorArchivo;

@Service

public class DocumentoTareaServiceImpl extends GeneralServiceImpl<DocumentoTarea, Integer>
		implements IDocumentoTareaService {

	@Autowired
	private IDocumentoTareaRepository repo;

	@Autowired
	private ITareaRepository tareaRepo;

	@Autowired
	private IAgendarTareaRepository ageTarRepo;

	@Autowired
	private IResponsableRepository repoRes;

	@Override
	protected GeneralRepo<DocumentoTarea, Integer> getRepo() {
		return repo;
	}

	@Autowired
	private IManejadorArchivo manejadorArchivo;

	@Value("${ruta.documentoTarea}")
	private String rutaDocumentoTarea;

	@Override
	public Integer subirArchivo(String json, MultipartFile archivoLlegada, String responsable) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		TareaDto tareaDto = objectMapper.readValue(json, TareaDto.class);

		Tarea validarTarea = new Tarea(tareaDto.getTarea().getNombre(), tareaDto.getTarea().getDescripcion(),
				tareaDto.getTarea().getLink(), tareaDto.getTarea().getTipoTarea(), tareaDto.getTarea().getCliente());

		Integer resultadoTarea = tareaRepo.insertar(validarTarea);
		validarTarea.setId(resultadoTarea);

		AgendarTarea validarAgeTarea = new AgendarTarea(tareaDto.getAgendarTarea().getFechaHoraInicio(),
				tareaDto.getAgendarTarea().getFechaHoraFin(), tareaDto.getAgendarTarea().getEstado(), validarTarea);

		int resuAgeTare = ageTarRepo.insertar(validarAgeTarea);
		validarAgeTarea.setId(resuAgeTare);
		Responsable respon = objectMapper.readValue(responsable, Responsable.class);

		respon.setAgendarTarea(validarAgeTarea);
		System.out.println(respon);

		repoRes.insertar(respon);

		DocumentoTarea documentoTarea = new DocumentoTarea();

		documentoTarea.setTarea(validarTarea);
		documentoTarea.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaDocumentoTarea));

		return repo.insertar(documentoTarea);
		//return null;
	}
	
	@Override
	public Integer insertarVariosResponsables(String json, MultipartFile archivoLlegada,String responsable) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		ResponsablesMultiplesDto responsablesMultiplesDto = objectMapper.readValue(json, ResponsablesMultiplesDto.class);

		Tarea validarTarea = new Tarea(responsablesMultiplesDto.getTareaDto().getTarea().getNombre(), responsablesMultiplesDto.getTareaDto().getTarea().getDescripcion(),
				responsablesMultiplesDto.getTareaDto().getTarea().getLink(), responsablesMultiplesDto.getTareaDto().getTarea().getTipoTarea(), responsablesMultiplesDto.getTareaDto().getTarea().getCliente());

		
		Integer resultadoTarea = tareaRepo.insertar(validarTarea);
		validarTarea.setId(resultadoTarea);

		AgendarTarea validarAgeTarea = new AgendarTarea(responsablesMultiplesDto.getTareaDto().getAgendarTarea().getFechaHoraInicio(),
				responsablesMultiplesDto.getTareaDto().getAgendarTarea().getFechaHoraFin(), responsablesMultiplesDto.getTareaDto().getAgendarTarea().getEstado(), validarTarea);

		int resuAgeTare = ageTarRepo.insertar(validarAgeTarea);
		validarAgeTarea.setId(resuAgeTare);
		
		//RESPONSABLES
		
		Responsable respon = objectMapper.readValue(responsable, Responsable.class);

		respon.setAgendarTarea(validarAgeTarea);

		repoRes.insertar(respon);
		
		for(Usuario u:responsablesMultiplesDto.getResponsables()) {
			if(repoRes.listarPorTareaYUsuario(validarAgeTarea.getId(), u.getId()) == 0) {
				Responsable res = new Responsable(u,validarAgeTarea);
				repoRes.insertar(res);
			}
		}

		DocumentoTarea documentoTarea = new DocumentoTarea();

		documentoTarea.setTarea(validarTarea);
		documentoTarea.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaDocumentoTarea));

		return repo.insertar(documentoTarea);
		//return null;
	}

	public void subirArchivoEditar(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		TareaDto tareaDto = objectMapper.readValue(json, TareaDto.class);

		Tarea validarTarea = new Tarea(tareaDto.getTarea().getId(), tareaDto.getTarea().getNombre(),
				tareaDto.getTarea().getDescripcion(), tareaDto.getTarea().getLink(), tareaDto.getTarea().getTipoTarea(),
				tareaDto.getTarea().getCliente());

		tareaRepo.actualizar(validarTarea);

		AgendarTarea validarAgeTarea = new AgendarTarea(tareaDto.getAgendarTarea().getId(),
				tareaDto.getAgendarTarea().getFechaHoraInicio(), tareaDto.getAgendarTarea().getFechaHoraFin(),
				tareaDto.getAgendarTarea().getEstado(), validarTarea);
		ageTarRepo.actualizar(validarAgeTarea);

		DocumentoTarea documentoTarea = new DocumentoTarea();

		documentoTarea.setTarea(validarTarea);

		DocumentoTarea documentoViejo = repo.listarPorId(documentoTarea.getId());

		try {
			if (!archivoLlegada.isEmpty()) {

				documentoTarea.setArchivo(manejadorArchivo.actualizarArchivo(archivoLlegada,
						documentoViejo.getArchivo(), rutaDocumentoTarea));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		repo.actualizar(documentoTarea);
	}
	
	@Override
	public byte[] obtenerArchivo(Integer id) throws IOException {

		DocumentoTarea documentoTarea = listarPorId(id);

		return manejadorArchivo.obtenerArchivo(rutaDocumentoTarea,documentoTarea.getArchivo());

	}

	@Override
	public void actualizarSinArchivo(String json) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		DocumentoTarea documentoTarea = objectMapper.readValue(json, DocumentoTarea.class);
		repo.actualizarSinArchivo(documentoTarea);

	}
}
