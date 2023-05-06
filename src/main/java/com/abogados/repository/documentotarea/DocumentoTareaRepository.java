package com.abogados.repository.documentotarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.abogados.model.documentotarea.DocumentoTarea;
@Repository
public class DocumentoTareaRepository implements IDocumentoTareaRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	private DocumentoTareaMapeador mapeo;

	@Override
	public List<DocumentoTarea> listar() {

		String sql = "select * from documentos_tarea";
		List<DocumentoTarea> lstDocumentoTarea = namedJdbcTemplate.query(sql, mapeo);

		return lstDocumentoTarea;
	}

	@Override
	public Integer insertar(DocumentoTarea documentoTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("archivo", documentoTarea.getArchivo());
		parameter.addValue("idTar", documentoTarea.getTarea().getId());

		String sql = "INSERT INTO documentos_tarea(dot_archivo, tar_id) VALUES(:archivo, :idTar);";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();

	}

	@Override
	public void actualizar(DocumentoTarea documentoTarea) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("archivo", documentoTarea.getArchivo());
		parameter.addValue("idTar", documentoTarea.getTarea().getId());
		parameter.addValue("id", documentoTarea.getId());

		String sql = "UPDATE documentos_tarea SET dot_archivo = :archivo, tar_id = :idTar WHERE dot_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public void eliminar(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM documentos_tarea WHERE dot_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}

	@Override
	public DocumentoTarea listarPorId(Integer id) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);
		String sql = "select * from documentos_tarea where dot_id = :id";
		List<DocumentoTarea> lstDocumentoTarea = namedJdbcTemplate.query(sql, parameter, mapeo);

		return lstDocumentoTarea.get(0);
	}

	@Override
	public void actualizarSinArchivo(DocumentoTarea json) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("idTar", json.getTarea().getId());
		parameter.addValue("id", json.getId());

		String sql = "UPDATE documentos_tarea SET tar_id = :idTar WHERE dot_id = :id;";

		namedJdbcTemplate.update(sql, parameter);

	}
	

}