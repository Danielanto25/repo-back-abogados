package com.abogados.repository.notificaciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.notificaciones.Notificaciones;
import com.abogados.model.responsables.Responsables;
import com.abogados.model.tarea.Tarea;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.responsables.IResponsablesRepository;
import com.abogados.repository.tarea.ITareaRepository;
import com.abogados.repository.usuario.IUsuarioRepository;

@Component
public class NotificacionesMapeador implements RowMapper<Notificaciones> {

	@Autowired
	private ITareaRepository tareaRepo;

	@Autowired
	private IUsuarioRepository usuarioRepo;
	
	@Autowired
	private IResponsablesRepository responsablesRepo;

	@Override
	public Notificaciones mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("com_id");
		LocalDateTime fecha = rs.getObject("not_fecha", LocalDateTime.class);
		Usuario usuario = usuarioRepo.listarPorId(rs.getInt("usu_id"));
		Tarea tarea = tareaRepo.listarPorId(rs.getInt("tar_id"));
		Responsables responsables =responsablesRepo.listarPorId(rs.getInt("res_id"));

		return new Notificaciones(id, fecha, usuario, tarea, responsables);

	}
	
}
