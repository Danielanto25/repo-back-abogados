package com.abogados.repository.actuacionproceso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.abogados.model.proceso.Proceso;
import com.abogados.repository.proceso.IProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.actuacionproceso.ActuacionProceso;

@Component
public class ActuacionProcesoMapeador implements RowMapper<ActuacionProceso> {

	@Autowired
	private IProcesoRepository procesoRepo;
	
	@Override
	public ActuacionProceso mapRow(ResultSet rs, int rowNum) throws SQLException {

		 Integer id = rs.getInt("acp_id");
		 String actuacion = rs.getString("acp_actuacion");
		 String anotacion = rs.getString("acp_anotacion");
		 String archivo = rs.getString("acp_archivo");
		 String fechaCreacion = rs.getString("acp_fecha_creacion");
		 LocalDateTime fechaHoraInicio = rs.getObject("acp_fecha_hora_inicio", LocalDateTime.class);
		 LocalDateTime FechaHoraFin = rs.getObject("acp_fecha_hora_fin", LocalDateTime.class);
		 Proceso proceso = procesoRepo.listarPorId(rs.getInt("pro_id"));

		return new ActuacionProceso(id, actuacion,anotacion,archivo, fechaCreacion, fechaHoraInicio, FechaHoraFin, proceso) ;
	}

	
	
	
	
	
	
}
