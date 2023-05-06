package com.abogados.repository.demandante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.demandante.Demandante;

@Repository
public class DemandanteRepository implements IDemandanteRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private DemandanteMapeador mapeo;
	
	@Override
	public List<Demandante> listar() {

		String sql = "select * from demandantes";
		List<Demandante> lstDemandante = namedJdbcTemplate.query(sql, mapeo);

		return lstDemandante;
	}
	
	@Override
	public Integer insertar(Demandante demandante) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandante", demandante.getDemandante());
		parameter.addValue("docDemandante", demandante.getDocDemandante());
		parameter.addValue("proceso", demandante.getProceso().getId());


		String sql = "INSERT INTO demandantes(dem_demandante, dem_doc_demandante, pro_id) "
				+ "VALUES(:demandante, :docDemandante, :proceso);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Demandante demandante) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("demandante", demandante.getDemandante());
		parameter.addValue("docDemandante", demandante.getDocDemandante());
		parameter.addValue("proceso", demandante.getProceso().getId());
		parameter.addValue("id", demandante.getId());

		String sql = "UPDATE demandantes SET dem_demandantes = :demandante, dem_doc_demandante = :docDemandante, pro_id = :proceso "
				+ "WHERE dem_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public void eliminar(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM demandantes WHERE dem_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public Demandante listarPorId(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from demandantes where dem_id = :id";

		List<Demandante> lstDemandante = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstDemandante.get(0);
	}
	
	@Override
	public List<Demandante> listarProcesoDemandante(Integer id){
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id",id);
		
		String sql = "select * from demandantes where pro_id = :id";
		
		List<Demandante> lstDemandante = namedJdbcTemplate.query(sql, parameter, mapeo);
		
		return lstDemandante;
	}

	@Override
	public void eliminarPorIdProceso(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM demandantes WHERE pro_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

}
