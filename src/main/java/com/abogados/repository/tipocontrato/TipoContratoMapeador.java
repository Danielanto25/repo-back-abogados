package com.abogados.repository.tipocontrato;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.tipocontrato.TipoContrato;

@Component

public class TipoContratoMapeador implements RowMapper<TipoContrato> {

	@Override
	public TipoContrato mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("tic_id");
		String nombre = rs.getString("tic_nombre");

		return new TipoContrato(id, nombre);

	}
}
