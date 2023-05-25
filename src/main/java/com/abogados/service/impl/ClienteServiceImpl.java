package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import com.abogados.util.TokenHelperComponent;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.cliente.Cliente;
import com.abogados.repository.cliente.IClienteRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IBibliotecaDocumentoService;
import com.abogados.service.IClienteService;
import com.abogados.service.IManejadorArchivo;

import javax.servlet.http.HttpServletRequest;

@Service

public class ClienteServiceImpl extends GeneralServiceImpl<Cliente, Integer> implements IClienteService {

	@Autowired
	private IClienteRepository repo;

	@Autowired
	private IManejadorArchivo manejadorArchivo;

	@Autowired
	private TokenHelperComponent token;
	@Autowired
	private IBibliotecaDocumentoService bibliotecaDocumentoService;

	@Value("${ruta.cliente}")
	private String rutaCliente;

	@Override
	protected GeneralRepo<Cliente, Integer> getRepo() {
		return repo;
	}

	@Override
	public Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		Cliente cliente = objectMapper.readValue(json, Cliente.class);

		cliente.setArchivo(manejadorArchivo.guardarArchivo(archivoLlegada, rutaCliente));

		return repo.insertar(cliente);
	}

	@Override
	public void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		Cliente cliente = objectMapper.readValue(json, Cliente.class);

		Cliente clienteViejo = repo.listarPorId(cliente.getId());

		try {
			if (!archivoLlegada.isEmpty()) {

				cliente.setArchivo(
						manejadorArchivo.actualizarArchivo(archivoLlegada, clienteViejo.getArchivo(), rutaCliente));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}

		repo.actualizar(cliente);
	}

	@Override
	public Cliente listarPorCliente(String cliente) throws IOException {
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		
		try {
			bibliotecaDocumentoService.eliminarDocumentosPorCliente(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repo.eliminar(id);
	
	}
	
	@Override
	public byte[] obtenerArchivo(Integer id) throws IOException {

		Cliente cliente = listarPorId(id);

		return manejadorArchivo.obtenerArchivo(rutaCliente, cliente.getArchivo());

	}

	@Override
	public void actualizarSinArchivo(String json) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Cliente cliente = objectMapper.readValue(json, Cliente.class);
		repo.actualizarSinArchivo(cliente);

	}


	public Cliente listarPorCliente( HttpServletRequest request) throws IOException {
		String usuario=token.obtenerUsuarioDelToken(request.getHeader("Authorization"));
		String cliente=repo.listarPorCliente(usuario).getNombre();
		return repo.listarPorCliente(cliente);
	}

	@Override
	public void eliminarArchivo(Integer id) throws IOException {

		Cliente cliente = listarPorId(id);
		//manejadorArchivo.eliminarArchivo(cliente.getArchivo(), rutaCliente);
		
		repo.eliminar(id);
	
	}
}
