package com.abogados.repository.responsable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.responsable.Responsable;
@Repository
public class ResponsableRepository implements IResponsableRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ResponsableMapeador mapeo;

	@Override
	public List<Responsable> listar() {

		String sql = "select * from responsables";
		List<Responsable> lstResponsable = namedJdbcTemplate.query(sql, mapeo);
		return lstResponsable;
	}

	@Override
	public Integer insertar(Responsable responsable) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("usuario", responsable.getUsuario().getId());
		parameter.addValue("agendarTarea", responsable.getAgendarTarea().getId());

		String sql = "INSERT INTO responsables(usu_id, agt_id) "
				+ "VALUES(:usuario, :agendarTarea);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Responsable t) {
		
	}

	@Override
	public void eliminar(Integer id) {
		
	}

	@Override
	public Responsable listarPorId(Integer id) {
		return null;
	}

	@Override
	public List<Responsable> listarPorIdAgendarTarea(int id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("agt_id", id);
		String sql = "select * from responsables where agt_id = :agt_id";
		
		List<Responsable> lstResponsable = namedJdbcTemplate.query(sql, parameter,mapeo);
		
		return lstResponsable;
	}

	@Override
	public int listarPorTareaYUsuario(int agtId, int usuId) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("agt_id", agtId);
		parameter.addValue("usu_id", usuId);
		String sql = "select * from responsables where agt_id = :agt_id and usu_id = :usu_id";
		
		List<Responsable> lstResponsable = namedJdbcTemplate.query(sql, parameter,mapeo);
		
		return lstResponsable.size();
	}

}