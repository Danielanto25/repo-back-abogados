package com.abogados.repository.comentario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.comentario.Comentario;
@Repository
public class ComentarioRepository implements IComentarioRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ComentarioMapeador mapeo;

	@Override
	public List<Comentario> listar() {

		String sql = "select * from comentarios";
		List<Comentario> lstComentario = namedJdbcTemplate.query(sql, mapeo);
		return lstComentario;
	}

	@Override
	public Integer insertar(Comentario comentario) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("texto", comentario.getTexto());
		parameter.addValue("idUsu", comentario.getUsuario().getId());
		parameter.addValue("idTar", comentario.getTarea().getId());

		String sql = "INSERT INTO comentarios(com_texto, usu_id, tar_id) VALUES(:texto, :idUsu, :idTar);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Comentario comentario) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("texto", comentario.getTexto());
		parameter.addValue("idUsu", comentario.getUsuario().getId());
		parameter.addValue("idTar", comentario.getTarea().getId());
		parameter.addValue("id", comentario.getId());

		String sql = "UPDATE comentarios SET com_texto = :texto, usu_id = :idUsu, tar_id = :idTar WHERE com_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM comentarios WHERE com_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public List<Comentario> listarPorIdComentario(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from comentarios where tar_id = :id";
		List<Comentario> lstComentario = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstComentario;
	}

	@Override
	public Comentario listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}