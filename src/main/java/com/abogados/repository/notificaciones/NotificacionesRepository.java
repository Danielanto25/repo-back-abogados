package com.abogados.repository.notificaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.notificaciones.Notificaciones;

@Repository
public class NotificacionesRepository implements INotificacionesRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private NotificacionesMapeador mapeo;
	
	@Override
	public List<Notificaciones> listar() {

		String sql = "select * from notificaciones";
		List<Notificaciones> lstNotificaciones = namedJdbcTemplate.query(sql, mapeo);
		return lstNotificaciones;
	}

	
	@Override
	public Integer insertar(Notificaciones notificaciones) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fecha", notificaciones.getFecha());
		parameter.addValue("idUsu", notificaciones.getUsuario().getId());
		parameter.addValue("idTar", notificaciones.getTarea().getId());
		parameter.addValue("idRes", notificaciones.getResponsables().getId());
		
		String sql = "INSERT INTO notificaciones(not_fecha, usu_id, tar_id, res_id) VALUES(:fecha, :idUsu, :idTar, :idRes);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Notificaciones notificaciones) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("fecha", notificaciones.getFecha());
		parameter.addValue("idUsu", notificaciones.getUsuario().getId());
		parameter.addValue("idTar", notificaciones.getTarea().getId());
		parameter.addValue("idRes", notificaciones.getResponsables().getId());
		parameter.addValue("id", notificaciones.getId());

		String sql = "UPDATE notificaciones SET not_fecha = :fecha, usu_id = :idUsu, tar_id = :idTar, res_id = :idRes WHERE not_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM notificaciones WHERE not_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public Notificaciones listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from notificaciones where not_id = :id";
		List<Notificaciones> lstNotificaciones = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstNotificaciones.get(0);
	}

}
	
	
	
	

