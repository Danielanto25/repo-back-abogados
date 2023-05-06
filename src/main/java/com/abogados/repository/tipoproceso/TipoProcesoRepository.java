package com.abogados.repository.tipoproceso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.tipoproceso.TipoProceso;
@Repository
public class TipoProcesoRepository implements ITipoProcesoRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private TipoProcesoMapeador mapeo;

	@Override
	public List<TipoProceso> listar() {

		String sql = "select * from tipos_proceso";
		List<TipoProceso> lstTipoProceso = namedJdbcTemplate.query(sql, mapeo);
		return lstTipoProceso;

	}

	@Override
	public Integer insertar(TipoProceso tipoProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoProceso.getNombre());

		String sql = "INSERT INTO tipos_proceso(tip_nombre) VALUES (:nombre);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(TipoProceso tipoProceso) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoProceso.getNombre());
		parameter.addValue("id", tipoProceso.getId());

		String sql = "UPDATE tipos_proceso SET tip_nombre = :nombre WHERE tip_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM tipos_proceso WHERE tip_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public TipoProceso listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from tipos_proceso where tip_id = :id";
		List<TipoProceso> lstTipoProceso = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstTipoProceso.get(0);

	}

}