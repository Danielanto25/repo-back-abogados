package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.bibliotecadocumento.BibliotecaDocumento;
import com.abogados.repository.bibliotecadocumento.IBibliotecaDocumentoRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IBibliotecaDocumentoService;
import com.abogados.service.IManejadorArchivo;

@Service

public class BibliotecaDocumentoServiceImpl extends GeneralServiceImpl<BibliotecaDocumento, Integer>
		implements IBibliotecaDocumentoService {

	@Autowired
	private IBibliotecaDocumentoRepository repo;

	@Autowired
	private IManejadorArchivo manejadorArchivo;
	@Value("${ruta.biblioteca}")
	private String rutaBiblioteca;

	@Override
	protected GeneralRepo<BibliotecaDocumento, Integer> getRepo() {
		return repo;
	}

	@Override
	public Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		BibliotecaDocumento bibliotecaDocumento = objectMapper.readValue(json, BibliotecaDocumento.class);

		bibliotecaDocumento.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaBiblioteca));

		return repo.insertar(bibliotecaDocumento);
	}

	@Override
	public void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		BibliotecaDocumento bibliotecaDocumento = objectMapper.readValue(json, BibliotecaDocumento.class);
		BibliotecaDocumento bibliotecaViejo = repo.listarPorId(bibliotecaDocumento.getId());

		try {
			if (!archivoLlegada.isEmpty()) {
				
				bibliotecaDocumento.setArchivo(manejadorArchivo.actualizarArchivo(archivoLlegada, bibliotecaViejo.getArchivo(), rutaBiblioteca));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}

		repo.actualizar(bibliotecaDocumento);
	}

	@Override
	public void eliminarArchivo(Integer id) throws IOException {

		BibliotecaDocumento bibliotecaDocumento = listarPorId(id);
		manejadorArchivo.eliminarArchivo(bibliotecaDocumento.getArchivo(), rutaBiblioteca);
		
		repo.eliminar(id);
	
	}
	
	@Override
	public void eliminarDocumentosPorCliente(Integer id) throws IOException {

		List<BibliotecaDocumento> documentos = repo.listarPorClienteId(id);
		
		for (BibliotecaDocumento bibliotecaDocumento : documentos) {
			manejadorArchivo.eliminarArchivo(bibliotecaDocumento.getArchivo(), rutaBiblioteca);
			
			repo.eliminar(id);
		}
	}
	
	@Override
	public byte[] obtenerArchivo(Integer id) throws IOException {

		BibliotecaDocumento bibliotecaDocumento = listarPorId(id);

		return manejadorArchivo.obtenerArchivo(rutaBiblioteca,bibliotecaDocumento.getArchivo());

	}

	@Override
	public void actualizarSinArchivo(String json) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		BibliotecaDocumento bibliotecaDocumento = objectMapper.readValue(json, BibliotecaDocumento.class);
		repo.actualizarSinArchivo(bibliotecaDocumento);

	}

	@Override
	public List<BibliotecaDocumento> listarPorCliente(String cliente) throws IOException {
		// TODO Auto-generated method stub
		return repo.listarPorCliente(cliente);
	}
}
