package com.abogados.repository.tipotarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.tipotarea.TipoTarea;

@Repository
public class TipoTareaRepository implements ITipoTareaRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private TipoTareaMapeador mapeo;

	@Override
	public List<TipoTarea> listar() {

		String sql = "select * from tipos_tarea";
		List<TipoTarea> lstTipoTarea = namedJdbcTemplate.query(sql, mapeo);
		return lstTipoTarea;

	}

	@Override
	public Integer insertar(TipoTarea tipoTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoTarea.getNombre());

		String sql = "INSERT INTO tipos_tarea(tit_nombre) VALUES(:nombre);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(TipoTarea tipoTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoTarea.getNombre());
		parameter.addValue("id", tipoTarea.getId());

		String sql = "UPDATE tipos_tarea SET tit_nombre = :nombre WHERE tit_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM tipos_tarea WHERE tit_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public TipoTarea listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from tipos_tarea where tit_id = :id";
		List<TipoTarea> lstTipoTarea = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstTipoTarea.get(0);

	}

}