package com.abogados.model.agendartarea;

import java.util.List;

import com.abogados.model.responsable.Responsable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendarTareaDto {

	private AgendarTarea agendarTarea;
	private List<Responsable> responsables;
}
