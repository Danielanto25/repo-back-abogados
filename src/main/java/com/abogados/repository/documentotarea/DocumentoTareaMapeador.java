package com.abogados.repository.documentotarea;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.documentotarea.DocumentoTarea;
import com.abogados.model.tarea.Tarea;
import com.abogados.repository.tarea.ITareaRepository;

@Component

public class DocumentoTareaMapeador implements RowMapper<DocumentoTarea> {

	@Autowired
	private ITareaRepository tareaRepo;

	@Override
	public DocumentoTarea mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("dot_id");
		String archivo = rs.getString("dot_archivo");
		Tarea tarea = tareaRepo.listarPorId(rs.getInt("tar_id"));

		return new DocumentoTarea(id, archivo, tarea);
	}

}
