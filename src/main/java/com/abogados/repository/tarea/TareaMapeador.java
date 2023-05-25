package com.abogados.repository.tarea;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.abogados.model.proceso.Proceso;
import com.abogados.repository.proceso.IProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.cliente.Cliente;
import com.abogados.model.tarea.Tarea;
import com.abogados.model.tipotarea.TipoTarea;
import com.abogados.repository.cliente.IClienteRepository;
import com.abogados.repository.tipotarea.ITipoTareaRepository;

@Component

public class TareaMapeador implements RowMapper<Tarea> {

	@Autowired
	private ITipoTareaRepository tipoTareaRepo;

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IProcesoRepository procesoRepo;

	@Override
	public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("tar_id");
		String nombre = rs.getString("tar_nombre");
		String descripcion = rs.getString("tar_descripcion");
		String link = rs.getString("tar_link");
		TipoTarea tipoTarea = tipoTareaRepo.listarPorId(rs.getInt("tit_id"));
		Cliente cliente = clienteRepo.listarPorId(rs.getInt("cli_id"));
		Proceso proceso = procesoRepo.listarPorId(rs.getInt("pro_id"));

		return new Tarea(id, nombre, descripcion, link, tipoTarea, cliente, proceso);

	}
}