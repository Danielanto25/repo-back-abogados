package com.abogados.repository.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.cliente.Cliente;
@Repository
public class ClienteRepository implements IClienteRepository {


	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private ClienteMapeador mapeo;

	@Override
	public List<Cliente> listar() {

		String sql = "select * from clientes";
		List<Cliente> lstCliente = namedJdbcTemplate.query(sql, mapeo);
		return lstCliente;
	}

	@Override
	public Integer insertar(Cliente cliente) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", cliente.getNombre());
		parameter.addValue("documento", cliente.getDocumento());
		parameter.addValue("descripcion", cliente.getDescripcion());
		parameter.addValue("numeroContrato", cliente.getNumeroContrato());
		parameter.addValue("archivo", cliente.getArchivo());
		parameter.addValue("idTip", cliente.getTipoContrato().getId());
		parameter.addValue("idTid", cliente.getTipoDocumento().getId());

		String sql = "INSERT INTO clientes(cli_nombre, cli_documento, cli_descripcion, cli_numero_contrato, cli_archivo, tic_id, tid_id) "
				+ "VALUES(:nombre, :documento, :descripcion, :numeroContrato, :archivo, :idTip, :idTid);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(Cliente cliente) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", cliente.getNombre());
		parameter.addValue("documento", cliente.getDocumento());
		parameter.addValue("descripcion", cliente.getDescripcion());
		parameter.addValue("numeroContrato", cliente.getNumeroContrato());
		parameter.addValue("archivo", cliente.getArchivo());
		parameter.addValue("idTip", cliente.getTipoContrato().getId());
		parameter.addValue("idTid", cliente.getTipoDocumento().getId());
		parameter.addValue("id", cliente.getId());

		String sql = "UPDATE clientes SET cli_nombre = :nombre, cli_documento = :documento, cli_descripcion = :descripcion, "
				+ "cli_numero_contrato = :numeroContrato, cli_archivo = :archivo, tic_id = :idTip, tid_id = :idTid WHERE cli_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM clientes WHERE cli_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public Cliente listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from clientes where cli_id = :id";
		List<Cliente> lstCliente = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstCliente.get(0);
	}
	@Override
	public Cliente listarPorCliente(String cliente) {
		System.err.println("-------------------Cliente recibido: " + cliente);
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("cliente", "%"+cliente+"%");
		
		String sql = "select * from clientes where cli_nombre like :cliente";
		
		Cliente c = namedJdbcTemplate.queryForObject(sql, parameter, mapeo);
		
		return c;
	}

	@Override
	public void actualizarSinArchivo(Cliente json) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", json.getNombre());
		parameter.addValue("documento", json.getDocumento());
		parameter.addValue("descripcion", json.getDescripcion());
		parameter.addValue("numeroContrato", json.getNumeroContrato());
		parameter.addValue("idTip", json.getTipoContrato().getId());
		parameter.addValue("idTid", json.getTipoDocumento().getId());
		parameter.addValue("id", json.getId());

		String sql = "UPDATE clientes SET cli_nombre = :nombre, cli_documento = :documento, cli_descripcion = :descripcion, "
				+ "cli_numero_contrato = :numeroContrato, tic_id = :idTip, tid_id = :idTid WHERE cli_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}


}