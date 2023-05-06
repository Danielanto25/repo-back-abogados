package com.abogados.model.proceso;

import java.util.List;

import com.abogados.model.demandado.Demandado;
import com.abogados.model.demandante.Demandante;

import com.abogados.repository.actuacionproceso.ProcesoDtoMapeador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoDto {

	private Proceso proceso;
	private List<Demandante> demandantes;
	private List<Demandado> demandados;

	}
