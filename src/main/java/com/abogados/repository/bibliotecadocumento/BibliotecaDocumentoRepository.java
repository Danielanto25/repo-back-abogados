package com.abogados.repository.bibliotecadocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.bibliotecadocumento.BibliotecaDocumento;
@Repository
public class BibliotecaDocumentoRepository implements IBibliotecaDocumentoRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private BibliotecaDocumentoMapeador mapeo;

	@Override
	public List<BibliotecaDocumento> listar() {

		String sql = "select * from biblioteca_documentos";
		List<BibliotecaDocumento> lstBibliotecaDocumento = namedJdbcTemplate.query(sql, mapeo);

		return lstBibliotecaDocumento;
	}

	@Override
	public Integer insertar(BibliotecaDocumento bibliotecaDocumento) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("archivo", bibliotecaDocumento.getArchivo());
		parameter.addValue("nombreArchivo", bibliotecaDocumento.getNombreArchivo());
		parameter.addValue("idCli", bibliotecaDocumento.getCliente().getId());

		String sql = "INSERT INTO biblioteca_documentos (bid_archivo, bid_nombre_archivo, cli_id) "
				+ "VALUES(:archivo, :nombreArchivo, :idCli);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(BibliotecaDocumento bibliotecaDocumento) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("archivo", bibliotecaDocumento.getArchivo());
		parameter.addValue("nombreArchivo", bibliotecaDocumento.getNombreArchivo());
		parameter.addValue("idCli", bibliotecaDocumento.getCliente().getId());
		parameter.addValue("id", bibliotecaDocumento.getId());

		String sql = "UPDATE biblioteca_documentos SET bid_archivo = :archivo, bid_nombre_archivo = :nombreArchivo, "
				+ "cli_id = :idCli WHERE bid_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}
	
	@Override
	public void actualizarSinArchivo(BibliotecaDocumento json) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombreArchivo", json.getNombreArchivo());
		parameter.addValue("idCli", json.getCliente().getId());
		parameter.addValue("id", json.getId());

		String sql = "UPDATE biblioteca_documentos SET bid_nombre_archivo = :nombreArchivo, "
				+ "cli_id = :idCli WHERE bid_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM biblioteca_documentos WHERE bid_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public BibliotecaDocumento listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from biblioteca_documentos where bid_id = :id";
		List<BibliotecaDocumento> lstBibliotecaDocumento = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstBibliotecaDocumento.get(0);
	}

	@Override
	public List<BibliotecaDocumento> listarPorCliente(String cliente) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("cliente", "%"+cliente+"%");
		
		String sql = "select * from biblioteca_documentos bd inner join clientes c on c.cli_id = bd.cli_id where c.cli_nombre like :cliente";
		
		List<BibliotecaDocumento> lstBibliotecaDocumento = namedJdbcTemplate.query(sql, parameter, mapeo);
		
		return lstBibliotecaDocumento;
	}
	
	@Override
	public List<BibliotecaDocumento> listarPorClienteId(Integer clienteId) {
		
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("clienteId", clienteId);
		
		String sql = "select * from biblioteca_documentos bd inner join clientes c on c.cli_id = bd.cli_id where c.cli_id = :clienteId";
		
		List<BibliotecaDocumento> lstBibliotecaDocumento = namedJdbcTemplate.query(sql, parameter, mapeo);
		
		return lstBibliotecaDocumento;
	}

}