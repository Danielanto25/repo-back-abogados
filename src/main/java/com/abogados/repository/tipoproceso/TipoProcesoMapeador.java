package com.abogados.repository.tipoproceso;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.tipoproceso.TipoProceso;

@Component
public class TipoProcesoMapeador implements RowMapper<TipoProceso> {

	@Override
	public TipoProceso mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("tip_id");
		String nombre = rs.getString("tip_nombre");

		return new TipoProceso(id, nombre);
	}

}
