package com.abogados.repository.estadoproceso;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.estadoproceso.EstadoProceso;

@Component

public class EstadoProcesoMapeador implements RowMapper<EstadoProceso> {

	@Override
	public EstadoProceso mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("esp_id");
		String nombre = rs.getString("esp_nombre");

		return new EstadoProceso(id, nombre);

	}
}