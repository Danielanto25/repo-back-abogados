package com.abogados.repository.estadoproceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.estadoproceso.EstadoProceso;
@Repository
public class EstadoProcesoRepository implements IEstadoProcesoRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private EstadoProcesoMapeador mapeo;

	@Override
	public List<EstadoProceso> listar() {

		String sql = "select * from estados_proceso";
		List<EstadoProceso> lstEstado = namedJdbcTemplate.query(sql, mapeo);

		return lstEstado;
	}

	@Override
	public Integer insertar(EstadoProceso estado) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", estado.getNombre());

		String sql = "INSERT INTO estados_proceso(esp_nombre) VALUES(:nombre);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(EstadoProceso estado) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", estado.getNombre());
		parameter.addValue("id", estado.getId());

		String sql = "UPDATE estados_proceso SET esp_nombre = :nombre WHERE esp_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM estados_proceso WHERE esp_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public EstadoProceso listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from estados_proceso where esp_id = :id";
		List<EstadoProceso> lstEstado = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstEstado.get(0);
	}

}