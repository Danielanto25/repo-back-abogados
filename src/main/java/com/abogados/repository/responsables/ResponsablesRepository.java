package com.abogados.repository.responsables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.responsables.Responsables;

@Repository
public class ResponsablesRepository implements IResponsablesRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ResponsablesMapeador mapeo;

	@Override
	public List<Responsables> listar() {

		String sql = "select * from responsables";
		List<Responsables> lstResponsables = namedJdbcTemplate.query(sql, mapeo);
		return lstResponsables;
	}

	@Override
	public Integer insertar(Responsables responsables) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("idRes", responsables.getId());
		parameter.addValue("idUsu", responsables.getUsuario().getId());
		parameter.addValue("idagt", responsables.getAgendarTarea().getId());

		String sql = "INSERT INTO responsables(res_id, usu_id, agt_id) VALUES(:idRes, :idUsu, :idTar);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Responsables responsables) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("idRes", responsables.getId());
		parameter.addValue("idUsu", responsables.getUsuario().getId());
		parameter.addValue("idagt", responsables.getAgendarTarea().getId());

		String sql = "UPDATE comentarios SET com_texto = :texto, usu_id = :idUsu, tar_id = :idTar WHERE com_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM responsables WHERE res_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public Responsables listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from responsables where res_id = :id";
		List<Responsables> lstResponsables = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstResponsables.get(0);
	}
}
