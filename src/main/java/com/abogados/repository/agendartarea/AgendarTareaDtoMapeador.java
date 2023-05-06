package com.abogados.repository.agendartarea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;
import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.model.responsable.Responsable;
import com.abogados.model.tarea.Tarea;
import com.abogados.repository.estadotarea.IEstadoTareaRepository;
import com.abogados.repository.responsable.IResponsableRepository;
import com.abogados.repository.tarea.ITareaRepository;

@Component
public class AgendarTareaDtoMapeador implements RowMapper<AgendarTareaDto>{
	
	@Autowired
	private IEstadoTareaRepository estadoRepo;
	
	@Autowired
	private ITareaRepository tareaRepo;
	
	@Autowired
	private IResponsableRepository responRepo;

	@Override
	public AgendarTareaDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		 Integer id = rs.getInt("agt_id");
		 LocalDateTime fechaHoraInicio = rs.getObject("agt_fecha_hora_inicio", LocalDateTime.class);
		 LocalDateTime FechaHoraFin = rs.getObject("agt_fecha_hora_fin", LocalDateTime.class);
		 EstadoTarea estado = estadoRepo.listarPorId(rs.getInt("esa_id"));
		 Tarea tarea = tareaRepo.listarPorId(rs.getInt("tar_id"));
		
		 List<Responsable> responsables = responRepo.listarPorIdAgendarTarea(id);
			
		 AgendarTarea agendaTarea = new AgendarTarea(id, fechaHoraInicio, FechaHoraFin, estado, tarea);
			
		 return new AgendarTareaDto(agendaTarea, responsables);
	}

}
