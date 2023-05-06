package com.abogados.model.dto;


import java.util.List;

import com.abogados.model.usuario.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponsablesMultiplesDto {

	
	 private TareaDto tareaDto;
	 private List<Usuario> responsables;
}
