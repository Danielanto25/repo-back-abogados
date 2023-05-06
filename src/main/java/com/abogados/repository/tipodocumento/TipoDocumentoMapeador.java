package com.abogados.repository.tipodocumento;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.tipodocumento.TipoDocumento;

@Component
public class TipoDocumentoMapeador implements RowMapper<TipoDocumento> {

	@Override
	public TipoDocumento mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("tid_id");
		String nombre = rs.getString("tid_nombre");

		return new TipoDocumento(id, nombre);
	}

}
