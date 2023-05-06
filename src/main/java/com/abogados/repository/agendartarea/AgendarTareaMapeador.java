package com.abogados.repository.agendartarea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.model.tarea.Tarea;
import com.abogados.repository.estadotarea.IEstadoTareaRepository;
import com.abogados.repository.tarea.ITareaRepository;

@Component

public class AgendarTareaMapeador implements RowMapper<AgendarTarea> {

	@Autowired
	private IEstadoTareaRepository estadoRepo;
	
	@Autowired
	private ITareaRepository tareaRepo;
	
	@Override
	public AgendarTarea mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 Integer id = rs.getInt("agt_id");
		 LocalDateTime fechaHoraInicio = rs.getObject("agt_fecha_hora_inicio", LocalDateTime.class);
		 LocalDateTime FechaHoraFin = rs.getObject("agt_fecha_hora_fin", LocalDateTime.class);
		 EstadoTarea estado = estadoRepo.listarPorId(rs.getInt("esa_id"));
		 Tarea tarea = tareaRepo.listarPorId(rs.getInt("tar_id"));
		
			
		return new AgendarTarea(id, fechaHoraInicio, FechaHoraFin, estado, tarea);
	}
	
	
	
	
}
