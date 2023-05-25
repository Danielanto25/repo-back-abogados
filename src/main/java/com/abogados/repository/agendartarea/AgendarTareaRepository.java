package com.abogados.repository.agendartarea;

import java.util.List;

import com.abogados.model.responsable.Responsable;
import com.abogados.model.responsables.Responsables;
import com.abogados.repository.responsable.ResponsableMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;
@Repository
public class AgendarTareaRepository implements IAgendarTareaRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private AgendarTareaMapeador mapeo;
	
	@Autowired
	private AgendarTareaDtoMapeador dtoMapeo;

	@Autowired
	private ResponsableMapeador resMapeo;

	@Override
	public List<AgendarTarea> listar() {
		String sql = "select * from agendar_tareas";
		List<AgendarTarea> lstAgendarTarea = namedJdbcTemplate.query(sql, mapeo);
		return lstAgendarTarea;
	}

	
	@Override
	public List<AgendarTareaDto> listarDto(){
		String sql = "select * from agendar_tareas";
		List<AgendarTareaDto> lstAgendarTarea = namedJdbcTemplate.query(sql, dtoMapeo);
		return lstAgendarTarea;
	}
	
	@Override
	public List<AgendarTareaDto> listarUser(String user) {
		String sql = "Select * from agendar_tareas agt inner join responsables res on res.agt_id = agt.agt_id inner join usuarios usu on res.usu_id = usu.usu_id where usu.usu_documento = '"+user+"'";
		List<AgendarTareaDto> lstAgendarTarea = namedJdbcTemplate.query(sql, dtoMapeo);
		return lstAgendarTarea;
	}

	@Override
	public Integer insertar(AgendarTarea agendarTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fechaHoraInicio", agendarTarea.getFechaHoraInicio());
		parameter.addValue("fechaHoraFin", agendarTarea.getFechaHoraFin());
		parameter.addValue("idEst", agendarTarea.getEstado().getId());
		parameter.addValue("idTar", agendarTarea.getTarea().getId());

		String sql = "INSERT INTO agendar_tareas(agt_fecha_hora_inicio, agt_fecha_hora_fin, esa_id, tar_id) "
				+ "VALUES(:fechaHoraInicio, :fechaHoraFin, :idEst, :idTar);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(AgendarTarea agendarTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fechaHoraInicio", agendarTarea.getFechaHoraInicio());
		parameter.addValue("fechaHoraFin", agendarTarea.getFechaHoraFin());
		parameter.addValue("idEst", agendarTarea.getEstado().getId());
		parameter.addValue("idTar", agendarTarea.getTarea().getId());
		parameter.addValue("id", agendarTarea.getId());

		String sql = "UPDATE agendar_tareas SET agt_fecha_hora_inicio = :fechaHoraInicio, agt_fecha_hora_fin = :fechaHoraFin, "
				+ "esa_id = :idEst, tar_id = :idTar WHERE agt_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM agendar_tareas WHERE agt_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public AgendarTarea listarTarea(Integer tareaId) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("tareaId", tareaId);
		String sql = "SELECT * FROM tareas INNER JOIN agendar_tareas agt ON agt.tar_id = tareas.tar_id INNER JOIN estados_tarea ON agt.esa_id = estados_tarea.esa_id WHERE agt.tar_id = :tareaId";
		List<AgendarTarea> lstTarea = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstTarea.get(0);

	}

	@Override
	public List<Responsable> listarResponsables(Integer agendarTarId){
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("agtId", agendarTarId);
		String sql = "SELECT * FROM responsables where agt_id = :agtId";
		List<Responsable> lstResponsables = namedJdbcTemplate.query(sql, parameter, resMapeo);
		return lstResponsables;
	}
	
	@Override
	public List<AgendarTarea> listarPorFechaInicio(String fechaInicio) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fechaInicio", fechaInicio);
		
		String sql = "SELECT * FROM agendar_tareas where CAST(agt_fecha_hora_inicio AS date) = :fechaInicio";
		
		List<AgendarTarea> lstAgendarTarea = namedJdbcTemplate.query(sql, parameter, mapeo);
		System.out.println("Repository"+lstAgendarTarea);
		
		return lstAgendarTarea;
	}

	@Override
	public List<AgendarTarea> listarPorFechaFin(String fechaFin) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fechaFin", fechaFin);
		
		String sql = "SELECT * FROM agendar_tareas where CAST(agt_fecha_hora_fin AS date) = :fechaFin";
		
		List<AgendarTarea> lstAgendarTarea = namedJdbcTemplate.query(sql, parameter, mapeo);
		
		return lstAgendarTarea;
	}

	@Override
	public AgendarTarea listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}