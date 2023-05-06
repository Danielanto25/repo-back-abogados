package com.abogados.repository.responsables;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.responsables.Responsables;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.agendartarea.IAgendarTareaRepository;
import com.abogados.repository.usuario.IUsuarioRepository;

@Component
public class ResponsablesMapeador implements RowMapper<Responsables> {

	@Autowired
	private IAgendarTareaRepository agendarTareaRepo;

	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public Responsables mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("res_id");
		AgendarTarea agendarTarea = agendarTareaRepo.listarPorId(rs.getInt("agt_id"));
		Usuario usuario = usuarioRepo.listarPorId(rs.getInt("usu_id"));

		return new Responsables(id, usuario, agendarTarea);

	}
}
