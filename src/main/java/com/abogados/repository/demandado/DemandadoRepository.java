package com.abogados.repository.demandado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.demandado.Demandado;

@Repository
public class DemandadoRepository implements IDemandadoRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private DemandadoMapeador mapeo;
	
	@Override
	public List<Demandado> listar() {

		String sql = "select * from demandados";
		List<Demandado> lstDemandado = namedJdbcTemplate.query(sql, mapeo);

		return lstDemandado;
	}
	
	@Override
	public Integer insertar(Demandado demandado) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandado", demandado.getDemandado());
		parameter.addValue("docDemandado", demandado.getDocDemandado());
		parameter.addValue("proceso", demandado.getProceso().getId());


		String sql = "INSERT INTO demandados(dos_demandado, dos_doc_demandado, pro_id) "
				+ "VALUES(:demandado, :docDemandado, :proceso);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Demandado demandado) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandado", demandado.getDemandado());
		parameter.addValue("docDemandado", demandado.getDocDemandado());
		parameter.addValue("proceso", demandado.getProceso().getId());
		parameter.addValue("id", demandado.getId());

		String sql = "UPDATE demandados SET dos_demandado = :demandado, dos_doc_demandado = :docDemandado, pro_id = :proceso "
				+ "WHERE dos_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public void eliminar(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM demandados WHERE dos_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public Demandado listarPorId(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from demandados where dos_id = :id";

		List<Demandado> lstDemandado = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstDemandado.get(0);
	}
	
	@Override
	public List<Demandado> listarProcesoDemandado(Integer id){
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id",id);
		
		String sql = "select * from demandados where pro_id = :id";
		
		List<Demandado> lstDemandado = namedJdbcTemplate.query(sql, parameter, mapeo);
		
		return lstDemandado;
	}

	@Override
	public void eliminarPorIdProceso(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM demandados WHERE pro_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

}
