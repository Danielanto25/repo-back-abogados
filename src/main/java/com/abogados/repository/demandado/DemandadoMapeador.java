package com.abogados.repository.demandado;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.demandado.Demandado;
import com.abogados.model.proceso.Proceso;
import com.abogados.repository.proceso.IProcesoRepository;

@Component
public class DemandadoMapeador implements RowMapper<Demandado>{

	@Override
	public Demandado mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("dos_id");
		String demandado = rs.getString("dos_demandado");
		String docDemandado = rs.getString("dos_doc_demandado");
//		Proceso proceso = procesorepo.listarPorId(rs.getInt("pro_id"));
		return new Demandado(id, demandado, docDemandado);

	}

}
