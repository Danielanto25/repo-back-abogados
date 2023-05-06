package com.abogados.repository.responsable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.responsable.Responsable;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.agendartarea.IAgendarTareaRepository;
import com.abogados.repository.usuario.IUsuarioRepository;


@Component
public class ResponsableMapeador implements RowMapper<Responsable> {

	
	@Autowired
	private IUsuarioRepository usuarioRepo;
	
	@Override
	public Responsable  mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	 Integer id = rs.getInt("res_id");
	 Usuario usuario = usuarioRepo.listarPorId(rs.getInt("usu_id"));
	 //AgendarTarea AgendarTarea = agendarTareaRepo.listarPorId(rs.getInt("agt_id")); 
	
	 return new Responsable(id,usuario);
}
}