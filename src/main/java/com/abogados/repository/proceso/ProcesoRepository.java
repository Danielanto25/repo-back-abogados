package com.abogados.repository.proceso;

import java.util.List;

import com.abogados.model.proceso.ProcesoDto;
import com.abogados.repository.actuacionproceso.ProcesoDtoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.proceso.Proceso;

@Repository
public class ProcesoRepository implements IProcesoRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ProcesoDtoMapeador procesoMapeo;

	@Autowired
	private ProcesoMapeador mapeo;

	@Override
	public List<Proceso> listar() {

		String sql = "select * from procesos";
		List<Proceso> lstProceso = namedJdbcTemplate.query(sql, mapeo);

		return lstProceso;
	}

	@Override
	public Integer insertar(Proceso proceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("numeroProceso", proceso.getNumeroProceso());
		parameter.addValue("corporacion", proceso.getCorporacion());
		parameter.addValue("ciudad", proceso.getCiudad());
		parameter.addValue("despacho", proceso.getDespacho());
		parameter.addValue("ponente", proceso.getPonente());
		parameter.addValue("cuantia", proceso.getCuantia());
		parameter.addValue("tribunal", proceso.getTribunal());
		parameter.addValue("idCli", proceso.getCliente().getId());
		parameter.addValue("idTip", proceso.getTipoProceso().getId());
		parameter.addValue("idEst", proceso.getEstado().getId());

		String sql = "INSERT INTO procesos(pro_numero_proceso, pro_corporacion, pro_ciudad, pro_despacho, pro_ponente, pro_cuantia, "
				+ "pro_tribunal, cli_id, tip_id, esp_id) VALUES(:numeroProceso, :corporacion, "
				+ ":ciudad, :despacho, :ponente, :cuantia, :tribunal, :idCli, :idTip, :idEst);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Proceso proceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("numeroProceso", proceso.getNumeroProceso());
		parameter.addValue("corporacion", proceso.getCorporacion());
		parameter.addValue("ciudad", proceso.getCiudad());
		parameter.addValue("despacho", proceso.getDespacho());
		parameter.addValue("ponente", proceso.getPonente());
		parameter.addValue("cuantia", proceso.getCuantia());
		parameter.addValue("tribunal", proceso.getTribunal());
		parameter.addValue("idCli", proceso.getCliente().getId());
		parameter.addValue("idTip", proceso.getTipoProceso().getId());
		parameter.addValue("idEst", proceso.getEstado().getId());
		parameter.addValue("id", proceso.getId());

		String sql = "UPDATE procesos SET pro_numero_proceso = :numeroProceso, pro_corporacion = :corporacion, pro_ciudad = :ciudad, "
				+ "pro_despacho = :despacho, pro_ponente = :ponente, pro_cuantia = :cuantia, pro_tribunal = :tribunal, cli_id = :idCli, "
				+ "tip_id = :idTip, esp_id = :idEst WHERE pro_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM procesos WHERE pro_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public Proceso listarPorNumeroProceso(String numeroProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("numeroProceso", numeroProceso);
		String sql = "select * from procesos where pro_numero_proceso = :numeroProceso";

		List<Proceso> lstProceso = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstProceso.get(0);
	}

	@Override
	public ProcesoDto listarPorId2(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from procesos where pro_id = :id";

		List<ProcesoDto> lstProceso = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		return lstProceso.get(0);
	}
	
	@Override
	public List<ProcesoDto> listarPorRadicado(String radicado) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("radicado", "%"+radicado+"%");
		
		String sql = "select * from procesos where pro_numero_proceso like :radicado";
		
		List<ProcesoDto> lstProcesos = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		
		return lstProcesos;
	}

	@Override
	public List<ProcesoDto> listarPorDespacho(String despacho) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("despacho", "%"+despacho+"%");
		
		String sql = "select * from procesos where pro_despacho like :despacho";
		
		List<ProcesoDto> lstProcesos = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		
		return lstProcesos;
	}
	
	@Override
	public List<ProcesoDto> listarPorDemandante(String demandante) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandante", "%"+demandante+"%");
		
		String sql = "select * from procesos inner join demandantes on procesos.pro_id = demandantes.pro_id where demandantes.dem_demandante like :demandante";
		
		List<ProcesoDto> lstProcesos = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		
		return lstProcesos;
	}
	
	@Override
	public List<ProcesoDto> listarPorDemandado(String demandado) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandado", "%"+demandado+"%");
		
		String sql = "select * from procesos inner join demandados on procesos.pro_id = demandados.pro_id where demandados.dos_demandado like :demandado";
		
		List<ProcesoDto> lstProcesos = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		
		return lstProcesos;
	}

	@Override
	public List<ProcesoDto> listarProcesoCliente(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from procesos where cli_id = :id";

		List<ProcesoDto> lstProceso = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		return lstProceso;
	}


	@Override
	public Proceso listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProcesoDto> listarProcesosPorCliente(String clienteDocumento) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("clienteDocumento", clienteDocumento);
		String sql = "select * from procesos inner join clientes on procesos.cli_id = clientes.cli_id where clientes.cli_documento = :clienteDocumento";

		List<ProcesoDto> lstProceso = namedJdbcTemplate.query(sql, parameter, procesoMapeo);
		return lstProceso;

	}

}