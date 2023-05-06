package com.abogados.repository.estadotarea;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.estadotarea.EstadoTarea;

@Component

public class EstadoTareaMapeador implements RowMapper<EstadoTarea> {

	@Override
	public EstadoTarea mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("esa_id");
		String nombre = rs.getString("esa_nombre");

		return new EstadoTarea(id, nombre);

	}
}