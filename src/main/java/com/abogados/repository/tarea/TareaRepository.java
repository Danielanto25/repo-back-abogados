package com.abogados.repository.tarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.tarea.Tarea;
@Repository
public class TareaRepository implements ITareaRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private TareaMapeador mapeo;

	@Override
	public List<Tarea> listar() {

		String sql = "select * from tareas";
		List<Tarea> lstTarea = namedJdbcTemplate.query(sql, mapeo);
		return lstTarea;

	}

	@Override
	public Integer insertar(Tarea tarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tarea.getNombre());
		parameter.addValue("descripcion", tarea.getDescripcion());
		parameter.addValue("link", tarea.getLink());
		parameter.addValue("idTit", tarea.getTipoTarea().getId());
		parameter.addValue("idCli", tarea.getCliente().getId());
		parameter.addValue("idPro", tarea.getProceso().getId());

		String sql = "INSERT INTO tareas(tar_nombre, tar_descripcion, tar_link, tit_id, cli_id, pro_id) "
				+ "VALUES(:nombre, :descripcion, :link, :idTit, :idCli, :idPro);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Tarea tarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tarea.getNombre());
		parameter.addValue("descripcion", tarea.getDescripcion());
		parameter.addValue("link", tarea.getLink());
		parameter.addValue("idTit", tarea.getTipoTarea().getId());
		parameter.addValue("idCli", tarea.getCliente().getId());
		parameter.addValue("idPro", tarea.getProceso().getId());
		parameter.addValue("id", tarea.getId());

		String sql = "UPDATE tareas SET tar_nombre = :nombre, tar_descripcion = :descripcion, tar_link = :link, tit_id = :idTit, "
				+ "cli_id = :idCli, pro_id = :idPro WHERE tar_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "UPDATE agendar_tareas SET est_id = 1 WHERE agendar_tareas.tar_id = :id";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public Tarea listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from tareas where tar_id = :id";

		List<Tarea> lstTarea = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstTarea.get(0);

	}
	
	
	@Override
	public void pasarReporte(Integer id, Integer idReporte) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		parameter.addValue("idReporte", idReporte);

		String sql = "UPDATE agendar_tareas SET esa_id = :idReporte WHERE agendar_tareas.tar_id = :id";

		namedJdbcTemplate.update(sql, parameter);

	}

}