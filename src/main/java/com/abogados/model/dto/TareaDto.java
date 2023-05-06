package com.abogados.model.dto;


import com.abogados.model.documentotarea.DocumentoTarea;
import com.abogados.model.tarea.Tarea;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TareaDto {
	
	private Tarea tarea;
	private FechaDto agendarTarea;
	private DocumentoTarea documentoTarea;
	
}
