package com.abogados.repository.demandante;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.demandante.Demandante;
import com.abogados.model.proceso.Proceso;
import com.abogados.repository.proceso.IProcesoRepository;

@Component
public class DemandanteMapeador implements RowMapper<Demandante>{

	@Override
	public Demandante mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("dem_id");
		String demandante = rs.getString("dem_demandante");
		String docDemandante = rs.getString("dem_doc_demandante");
//		Proceso proceso = procesorepo.listarPorId(rs.getInt("pro_id"));
		return new Demandante(id, demandante, docDemandante);

	}

}
