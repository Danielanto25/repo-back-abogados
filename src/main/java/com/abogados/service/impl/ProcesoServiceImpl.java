package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abogados.model.demandado.Demandado;
import com.abogados.model.demandante.Demandante;
import com.abogados.model.proceso.Proceso;
import com.abogados.model.proceso.ProcesoDto;
import com.abogados.repository.actuacionproceso.IActuacionProcesoRepository;
import com.abogados.repository.demandado.IDemandadoRepository;
import com.abogados.repository.demandante.IDemandanteRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.proceso.IProcesoRepository;
import com.abogados.service.IProcesoService;
import com.abogados.util.TokenHelperComponent;

@Service

public class ProcesoServiceImpl extends GeneralServiceImpl<Proceso, Integer> implements IProcesoService {

	@Autowired
	private IProcesoRepository repo;

	@Autowired
	private IActuacionProcesoRepository actuacionRepo;

	@Autowired
	private IDemandadoRepository repoDemandado;

	@Autowired
	private IDemandanteRepository repoDemandante;

	@Autowired
	private TokenHelperComponent token;


	@Override
	protected GeneralRepo<Proceso, Integer> getRepo() {
		return repo;
	}

	@Override
	@Transactional
	public Integer insertar(ProcesoDto procesoDto) {

		Integer id = repo.insertar(procesoDto.getProceso());
		Proceso proceso = procesoDto.getProceso();
		proceso.setId(id);
		for (Demandado d : procesoDto.getDemandados()) {
			d.setProceso(proceso);
			repoDemandado.insertar(d);
		}
		for (Demandante d : procesoDto.getDemandantes()) {
			d.setProceso(proceso);
			repoDemandante.insertar(d);
		}
		return id;
	}
	

	@Override
	public Proceso listarPorNumeroProceso(String numeroProceso) {
		return repo.listarPorNumeroProceso(numeroProceso);
	}
	
	@Override
	public ProcesoDto listarPorId2(Integer id) {
		return repo.listarPorId2(id);
	}

	@Override
	public List<ProcesoDto> listarPorRadicado(String radicado) throws IOException {
		return repo.listarPorRadicado(radicado);
	}

	public List<ProcesoDto> listarPorDespacho(String despacho) throws IOException {
		return repo.listarPorDespacho(despacho);
	}

	public List<ProcesoDto> listarPorDemandante(String demandante) throws IOException {
		return repo.listarPorDemandante(demandante);
	}

	public List<ProcesoDto> listarPorDemandado(String demandado) throws IOException {
		return repo.listarPorDemandado(demandado);
	}

	@Override
	public List<ProcesoDto> listarProcesoCliente( HttpServletRequest request) throws IOException {
		String usuario=token.obtenerUsuarioDelToken(request.getHeader("Authorization"));
		return repo.listarProcesosPorCliente(usuario);
 
	}

	@Override
	public List<ProcesoDto> listarDto() throws IOException {
		
		return actuacionRepo.listarDto();
	}

	@Override
	public void actualizarCompleto(ProcesoDto procesoDto) {
		
		repo.actualizar(procesoDto.getProceso());
		Proceso proceso = procesoDto.getProceso();
		
		repoDemandado.eliminarPorIdProceso(proceso.getId());
		repoDemandante.eliminarPorIdProceso(proceso.getId());
		
		for (Demandado d : procesoDto.getDemandados()) {
			d.setProceso(proceso);
			repoDemandado.insertar(d);
		}
		for (Demandante d : procesoDto.getDemandantes()) {
			d.setProceso(proceso);
			repoDemandante.insertar(d);
		}
		
		
	}



}
