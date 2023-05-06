package com.abogados.repository.bibliotecadocumento;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.abogados.model.bibliotecadocumento.BibliotecaDocumento;
import com.abogados.model.cliente.Cliente;
import com.abogados.repository.cliente.IClienteRepository;

@Component

public class BibliotecaDocumentoMapeador implements RowMapper<BibliotecaDocumento> {
	
	@Autowired
	private IClienteRepository clienteRepo;
	
	@Override
	public BibliotecaDocumento mapRow(ResultSet rs, int rowNum) throws SQLException {

		Integer id = rs.getInt("bid_id");
		String archivo = rs.getString("bid_archivo");
		String nombreArchivo = rs.getString("bid_nombre_archivo");
		Cliente cliente = clienteRepo.listarPorId(rs.getInt("cli_id"));

		return new BibliotecaDocumento(id, archivo, nombreArchivo, cliente);
	}
	
	
	

}
