package com.abogados.repository.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.abogados.model.estado.Estado;
import com.abogados.model.tipodocumento.TipoDocumento;
import com.abogados.model.usuario.Usuario;
import com.abogados.repository.estado.IEstadoRepository;
import com.abogados.repository.tipodocumento.ITipoDocumentoRepository;

@Component
public class UsuarioMapeador implements RowMapper<Usuario> {

	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepo;

	@Autowired
	private IEstadoRepository estadoRepo;

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Integer id = rs.getInt("usu_id");
		String nombre = rs.getString("usu_nombre");
		String apellido = rs.getString("usu_apellido");
		String email = rs.getString("usu_email");
		String password = rs.getString("usu_password");
		String documento = rs.getString("usu_documento");
		TipoDocumento tipoDocumento = tipoDocumentoRepo.listarPorId(rs.getInt("tid_id"));
		Estado estado = estadoRepo.listarPorId(rs.getInt("est_id"));

		if(apellido == null && email == null) {
			return new Usuario(id, nombre, password, documento, tipoDocumento, estado);
		}else {
			return new Usuario(id, nombre, apellido, email, password, documento, tipoDocumento, estado);
		}
	}

}
