package com.abogados.repository.actuacionproceso;

import java.util.List;

import com.abogados.model.proceso.ProcesoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.actuacionproceso.ActuacionProceso;
@Repository
public class ActuacionProcesoRepository implements IActuacionProcesoRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ActuacionProcesoMapeador mapeo;

	@Autowired
	private ProcesoDtoMapeador procesoMapeo;
	@Override
	public List<ActuacionProceso> listar() {

		String sql = "select * from actuaciones_proceso";
		List<ActuacionProceso> lstActuacionProceso = namedJdbcTemplate.query(sql,mapeo); 

		return lstActuacionProceso;
	}
	@Override
	public Integer insertar(ActuacionProceso actuacionProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("actuacion", actuacionProceso.getActuacion());
		parameter.addValue("anotacion", actuacionProceso.getAnotacion());
		parameter.addValue("archivo", actuacionProceso.getArchivo());
		parameter.addValue("fechaCreacion", actuacionProceso.getFechaCreacion());
		parameter.addValue("fechaInicio", actuacionProceso.getFechaHoraInicio());
		parameter.addValue("fechaFin", actuacionProceso.getFechaHoraFin());
		parameter.addValue("idProceso", actuacionProceso.getProceso().getId());

		String sql = "INSERT INTO actuaciones_proceso(acp_actuacion, acp_anotacion, acp_archivo, acp_fecha_creacion, acp_fecha_hora_inicio, acp_fecha_hora_fin, pro_id) "
				+ "VALUES (:actuacion, :anotacion, :archivo, :fechaCreacion, :fechaInicio, :fechaFin, :idProceso);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}
	
	@Override
	public Integer insertarSinFechas(ActuacionProceso actuacionProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("actuacion", actuacionProceso.getActuacion());
		parameter.addValue("anotacion", actuacionProceso.getAnotacion());
		parameter.addValue("archivo", actuacionProceso.getArchivo());
		parameter.addValue("fechaCreacion", actuacionProceso.getFechaCreacion());
		parameter.addValue("idProceso", actuacionProceso.getProceso().getId());

		String sql = "INSERT INTO actuaciones_proceso(acp_actuacion, acp_anotacion, acp_archivo, acp_fecha_creacion, pro_id) "
				+ "VALUES (:actuacion, :anotacion, :archivo, :fechaCreacion, :idProceso);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}
	
	
	@Override
	public void actualizar(ActuacionProceso actuacionProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("actuacion", actuacionProceso.getActuacion());
		parameter.addValue("anotacion", actuacionProceso.getAnotacion());
		parameter.addValue("archivo", actuacionProceso.getArchivo());
//		parameter.addValue("fechaCreacion", actuacionProceso.getFechaCreacion());
//		parameter.addValue("fechaInicio", actuacionProceso.getFechaHoraInicio());
//		parameter.addValue("fechaFin", actuacionProceso.getFechaHoraFin());
		parameter.addValue("id", actuacionProceso.getId());
//		parameter.addValue("idProceso", actuacionProceso.getProceso().getId());

		String sql = "UPDATE actuaciones_proceso SET acp_actuacion = :actuacion, acp_anotacion = :anotacion, "
				+ "acp_archivo = :archivo WHERE acp_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}
	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM actuaciones_proceso WHERE acp_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}
	@Override
	public ActuacionProceso listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from actuaciones_proceso where acp_id = :id";
		List<ActuacionProceso> lstActuacionProceso = namedJdbcTemplate.query(sql,parameter, mapeo);

		return lstActuacionProceso.get(0);
	}
//	@Override
//	public List<ActuacionProceso> listarPorNumeroProceso(String numeroProceso) {
//		
//		MapSqlParameterSource parameter = new MapSqlParameterSource();
//		parameter.addValue("numeroProceso", numeroProceso);
//		
//		String sql = "select * from actuaciones_proceso where pro_id = :numeroProceso";
//		List<ActuacionProceso> lstActuacionProceso = namedJdbcTemplate.query(sql,parameter, mapeo);
//		
//		return lstActuacionProceso.get(0);
//	}
	@Override
	public List<ActuacionProceso> listarPorIdProceso(int id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from actuaciones_proceso where pro_id = :id";
		List<ActuacionProceso> lstActuacionProceso = namedJdbcTemplate.query(sql,parameter, mapeo);
		
		return lstActuacionProceso;
	}
	@Override
	public void actualizarSinArchivo(ActuacionProceso actuacionProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("actuacion", actuacionProceso.getActuacion());
		parameter.addValue("anotacion", actuacionProceso.getAnotacion());
		parameter.addValue("fechaCreacion", actuacionProceso.getFechaCreacion());
		parameter.addValue("fechaInicio", actuacionProceso.getFechaHoraInicio());
		parameter.addValue("fechaFin", actuacionProceso.getFechaHoraFin());
		parameter.addValue("id", actuacionProceso.getId());
		parameter.addValue("idProceso", actuacionProceso.getProceso().getId());

		String sql = "UPDATE actuaciones_proceso SET acp_actuacion = :actuacion, acp_anotacion = :anotacion, acp_fecha_creacion = :fechaCreacion, acp_fecha_hora_inicio = :fechaInicio, "
				+ "acp_fecha_hora_fin = :fechaFin, pro_id = :idProceso WHERE acp_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

		}
	
	@Override
	public List<ActuacionProceso> listarPorNumeroProceso(String numeroProceso){
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("numeroProceso", "%"+numeroProceso+"%");
		String sql = "SELECT * FROM actuaciones_proceso a JOIN procesos p ON a.pro_id = p.pro_id WHERE p.pro_numero_proceso like :numeroProceso;";
		List<ActuacionProceso> lstActuacionProceso = namedJdbcTemplate.query(sql,parameter, mapeo);
		
		return lstActuacionProceso;
		
	}

	@Override
	public List<ProcesoDto> listarDto() {
		String sql = "select * from procesos";
		List<ProcesoDto> lstProceso = namedJdbcTemplate.query(sql, procesoMapeo);

		return lstProceso;
	}
		
	}

