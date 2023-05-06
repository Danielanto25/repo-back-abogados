package com.abogados.repository.tipotarea;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.tipotarea.TipoTarea;

@Component
public class TipoTareaMapeador implements RowMapper<TipoTarea> {

	@Override
	public TipoTarea mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("tit_id");
		String nombre = rs.getString("tit_nombre");

		return new TipoTarea(id, nombre);
	}

}