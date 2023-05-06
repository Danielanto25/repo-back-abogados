package com.abogados.repository.estadotarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.estadotarea.EstadoTarea;


@Repository
public class EstadoTareaRepository implements IEstadoTareaRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private EstadoTareaMapeador mapeo;

	@Override
	public List<EstadoTarea> listar() {

		String sql = "select * from estados_tarea";
		List<EstadoTarea> lstEstado = namedJdbcTemplate.query(sql, mapeo);

		return lstEstado;
	}

	@Override
	public Integer insertar(EstadoTarea estado) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", estado.getNombre());

		String sql = "INSERT INTO estados_tarea(esa_nombre) VALUES(:nombre);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(EstadoTarea estado) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", estado.getNombre());
		parameter.addValue("id", estado.getId());

		String sql = "UPDATE estados_tarea SET esa_nombre = :nombre WHERE esa_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM estados_tarea WHERE esa_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public EstadoTarea listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from estados_tarea where esa_id = :id";
		List<EstadoTarea> lstEstado = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstEstado.get(0);
	}

}