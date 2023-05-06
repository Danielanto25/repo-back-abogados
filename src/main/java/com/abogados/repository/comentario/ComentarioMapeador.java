package com.abogados.repository.comentario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.comentario.Comentario;
import com.abogados.model.tarea.Tarea;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.tarea.ITareaRepository;
import com.abogados.repository.usuario.IUsuarioRepository;

@Component

public class ComentarioMapeador implements RowMapper<Comentario> {

	@Autowired
	private ITareaRepository tareaRepo;

	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("com_id");
		String texto = rs.getString("com_texto");
		Usuario usuario = usuarioRepo.listarPorId(rs.getInt("usu_id"));
		Tarea tarea = tareaRepo.listarPorId(rs.getInt("tar_id"));

		return new Comentario(id, texto, usuario, tarea);

	}

}
