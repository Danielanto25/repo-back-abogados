package com.abogados.repository.cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.cliente.Cliente;
import com.abogados.model.tipocontrato.TipoContrato;
import com.abogados.model.tipodocumento.TipoDocumento;
import com.abogados.repository.tipocontrato.ITipoContratoRepository;
import com.abogados.repository.tipodocumento.ITipoDocumentoRepository;


@Component
public class ClienteMapeador implements RowMapper<Cliente> {
	
	@Autowired
	private ITipoContratoRepository tipoContratoRepo;
	
	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepo;
	
	@Override
	public Cliente  mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	 Integer id = rs.getInt("cli_id");
	 String nombre = rs.getString("cli_nombre");
	 String documento = rs.getString("cli_documento");
	 String descripcion = rs.getString("cli_descripcion");
	 String numeroContrato = rs.getString("cli_numero_contrato");
	 String archivo = rs.getString("cli_archivo");
	 TipoContrato tipoContrato = tipoContratoRepo.listarPorId(rs.getInt("tic_id"));
	 TipoDocumento tipoDocumento = tipoDocumentoRepo.listarPorId(rs.getInt("tid_id"));
	
	 return new Cliente(id,nombre,documento,descripcion,numeroContrato,archivo,tipoContrato,tipoDocumento);
}
}