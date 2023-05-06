package com.abogados.repository.proceso;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.cliente.Cliente;
import com.abogados.model.estadoproceso.EstadoProceso;
import com.abogados.model.proceso.Proceso;
import com.abogados.model.tipoproceso.TipoProceso;
import com.abogados.repository.cliente.IClienteRepository;
import com.abogados.repository.estadoproceso.IEstadoProcesoRepository;
import com.abogados.repository.tipoproceso.ITipoProcesoRepository;

@Component
public class ProcesoMapeador implements RowMapper<Proceso> {

	@Autowired
	private ITipoProcesoRepository tipoProcesorepo;

	@Autowired
	private IEstadoProcesoRepository estadorepo;
	
	@Autowired
	private IClienteRepository clienterepo;

	@Override
	public Proceso mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("pro_id");
		String numeroProceso = rs.getString("pro_numero_proceso");
		String corporacion = rs.getString("pro_corporacion");
		String ciudad = rs.getString("pro_ciudad");
		String despacho = rs.getString("pro_despacho");
		String ponente = rs.getString("pro_ponente");
		String cuantia = rs.getString("pro_cuantia");
		String tribunal = rs.getString("pro_tribunal");
		Cliente cliente = clienterepo.listarPorId(rs.getInt("cli_id"));
		TipoProceso tipoProceso = tipoProcesorepo.listarPorId(rs.getInt("tip_id"));
		EstadoProceso estado = estadorepo.listarPorId(rs.getInt("esp_id"));
		return new Proceso(id, numeroProceso, corporacion, ciudad, despacho, ponente, cuantia, tribunal, cliente, tipoProceso, estado);

	}
}