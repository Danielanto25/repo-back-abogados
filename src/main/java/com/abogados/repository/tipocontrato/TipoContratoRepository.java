package com.abogados.repository.tipocontrato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.tipocontrato.TipoContrato;
@Repository
public class TipoContratoRepository implements ITipoContratoRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private TipoContratoMapeador mapeo;

	@Override
	public List<TipoContrato> listar() {

		String sql = "select * from tipos_contrato";
		List<TipoContrato> lstTipoContrato = namedJdbcTemplate.query(sql, mapeo);
		return lstTipoContrato;

	}

	@Override
	public Integer insertar(TipoContrato tipoContrato) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoContrato.getNombre());

		String sql = "INSERT INTO tipos_contrato(tic_nombre) VALUES(:nombre);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(TipoContrato tipoContrato) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", tipoContrato.getNombre());
		parameter.addValue("id", tipoContrato.getId());

		String sql = "UPDATE tipos_contrato SET tic_nombre = :nombre WHERE tic_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM tipos_contrato WHERE tic_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public TipoContrato listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from tipos_contrato where tic_id = :id";
		List<TipoContrato> lstTipoContrato = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstTipoContrato.get(0);
	}

}